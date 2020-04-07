package sse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameControllerCheckTest {

    GameController ctl;
    Field boardField;

    @Before
    public void setUp() throws NoSuchFieldException {
        ctl=new GameController();
        boardField =ctl.getClass().getDeclaredField("board");
        boardField.setAccessible(true);
    }

    @After
    public void tearDown(){
        ctl=null;
        boardField =null;
    }

    @Test
    public void checkWinningBasic() {
        assertFalse(ctl.checkWinning());
    }

    @Test
    public void checkWinningPCT1() throws IllegalAccessException {
        int[][] boardStatus=new int[][]{
                {0,0,0,0,0,0}, {1,2,0,0,0,0}, {1,2,0,0,0,0}, {1,2,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}
        };
        boardField.set(ctl,new BoardStub(boardStatus));
        ctl.setChess(0);
        assertTrue(ctl.checkWinning());
    }

    @Test
    public void checkWinningPCT2() throws IllegalAccessException {
        int[][] boardStatus=new int[][]{
                {0,0,0,0,0,0}, {1,1,1,0,0,0}, {2,2,2,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}
        };
        boardField.set(ctl,new BoardStub(boardStatus));
        ctl.setChess(1);
        assertTrue(ctl.checkWinning());
    }

    @Test
    public void checkWinningPCT3() throws IllegalAccessException {
        int[][] boardStatus=new int[][]{
                {0,0,0,0,0,0}, {1,2,2,0,0,0}, {1,2,1,0,0,0}, {1,1,2,0,0,0}, {1,2,2,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}
        };
        boardField.set(ctl,new BoardStub(boardStatus));
        ctl.setChess(1);
        assertTrue(ctl.checkWinning());
    }

    @Test
    public void checkWinningPCT4() throws IllegalAccessException {
        int[][] boardStatus=new int[][]{
                {0,0,0,0,0,0}, {2,1,0,0,0,0}, {1,2,1,0,0,0}, {1,2,2,1,0,0}, {2,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}
        };
        boardField.set(ctl,new BoardStub(boardStatus));
        ctl.setChess(0);
        assertTrue(ctl.checkWinning());
    }

    @Test
    public void checkWinningPCT5() throws IllegalAccessException {
        int[][] boardStatus=new int[][]{
                {0,0,0,0,0,0}, {1,2,0,0,0,0}, {2,1,0,0,0,0}, {1,2,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}
        };
        boardField.set(ctl,new BoardStub(boardStatus));
        ctl.setChess(0);
        assertFalse(ctl.checkWinning());
    }

    @Test
    public void isFinishedCT1() throws IllegalAccessException {
        int[][] boardStatus=new int[][]{
                {0,0,0,0,0,0}, {2,1,0,0,0,0}, {1,2,1,0,0,0}, {1,2,2,1,0,0}, {2,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}
        };
        boardField.set(ctl,new BoardStub(boardStatus));
        ctl.setChess(0);
        assertTrue(ctl.isFinished());
    }

    @Test
    public void isFinishedCT2() throws IllegalAccessException {
        int[][] boardStatus=new int[][]{
                {1,2,1,2,1,2}, {2,1,2,1,2,1}, {2,1,2,1,2,1}, {1,2,1,2,1,2},  {1,2,1,2,1,2}, {2,1,2,1,2,1}, {2,1,2,1,2,0}
        };
        boardField.set(ctl,new BoardStub(boardStatus));
        ctl.setChess(6);
        assertTrue(ctl.isFinished());
    }

    @Test
    public void isFinishedCT3() throws IllegalAccessException {
        int[][] boardStatus=new int[][]{
                {0,0,0,0,0,0}, {2,1,0,0,0,0}, {1,2,1,0,0,0}, {1,2,2,1,0,0}, {2,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}
        };
        boardField.set(ctl,new BoardStub(boardStatus));
        ctl.setChess(3);
        assertFalse(ctl.isFinished());
    }
}