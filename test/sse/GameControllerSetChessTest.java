package sse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class GameControllerSetChessTest {

    GameController ctl;
    Board boardOfCtl;
    Field boardField;

    @Before
    public void setUp() throws Exception {
        ctl=new GameController();
        boardField=ctl.getClass().getDeclaredField("board");
        boardField.setAccessible(true);
        boardOfCtl=(Board) boardField.get(ctl);
    }

    @After
    public void tearDown() throws Exception {
        ctl=null;
        boardOfCtl=null;
        boardField=null;
    }

    @Test
    public void setChessOnceBasicFunctionTest(){
        assertTrue(ctl.setChess(2));
        int[][] boardStatus=boardOfCtl.getGameBoard();
        assertArrayEquals( new int[]{1,0,0,0,0,0},boardStatus[2]);
    }
    @Test
    public void setChessTwiceBasicFunctionTest() throws IllegalAccessException{
        assertTrue(ctl.setChess(3));
        assertTrue(ctl.setChess(3));
        int[][] boardStatus=boardOfCtl.getGameBoard();
        assertArrayEquals( new int[]{1,2,0,0,0,0},boardStatus[3]);
    }

    @Test
    public void setChessColumnTooSmall() throws IllegalAccessException{
        assertFalse(ctl.setChess(-1));
        int[][] boardStatus=boardOfCtl.getGameBoard();
        for(int[] column:boardStatus)assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0},column);
    }

    @Test
    public void setChessColumnTooLarge() throws IllegalAccessException{
        assertFalse(ctl.setChess(7));
        int[][] boardStatus=boardOfCtl.getGameBoard();
        for(int[] column:boardStatus)assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0},column);
    }

    @Test
    public void setChessBVT2() {
        for(int i=0;i<42;i++){
            ctl.setChess(i%7);
        }
        int prevPlayer=ctl.getCurrentPlayer();
        int[][] boardArrayBefore=boardOfCtl.getGameBoard();
        assertFalse(ctl.setChess(3));
        assertEquals(ctl.getCurrentPlayer(),prevPlayer);
        assertArrayEquals(boardArrayBefore,boardOfCtl.getGameBoard());
    }
}