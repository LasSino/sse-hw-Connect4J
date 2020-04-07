package sse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class GameControllerSetChessTest {

    GameController ctl;

    @Before
    public void setUp() throws Exception {
        ctl=new GameController();
    }

    @After
    public void tearDown() throws Exception {
        ctl=null;
    }


    @Test
    public void setChessBasic() {
        assertTrue(ctl.setChess(3));
        assertEquals(ctl.getCurrentPlayer(),2);
    }

    @Test
    public void setChessDT1() {
        ctl.setChess(3);
        assertTrue(ctl.setChess(3));
        assertEquals(ctl.getCurrentPlayer(),1);
    }

    @Test
    public void setChessBVT1() {
        assertFalse(ctl.setChess(7));
        assertEquals(ctl.getCurrentPlayer(),1);
    }

    @Test
    public void setChessBVT2() {
        for(int i=0;i<42;i++){
            ctl.setChess(i%7);
        }
        int prevPlayer=ctl.getCurrentPlayer();
        assertFalse(ctl.setChess(3));
        assertEquals(ctl.getCurrentPlayer(),prevPlayer);
    }
}