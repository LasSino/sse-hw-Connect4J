package sse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

/**
 * This test tests the basic functions of the {@code: Board} class.
 *
 * All the test cases are ran on a empty board.
 */
public class BoardBasicTest {
    Board board;
    Field boardArrayField;

    @Before
    public void setUp() throws Exception {
        board=new Board();
        boardArrayField =board.getClass().getDeclaredField("gameBoard");
        boardArrayField.setAccessible(true);
    }

    @After
    public void tearDown() throws Exception {
        board=null;
    }

    @Test
    public void setChessBasic() throws IllegalAccessException {
        assertTrue(board.setChess(6, 1));
        int[][] boardStatus=(int[][]) boardArrayField.get(board);
        assertArrayEquals(new int[]{1, 0, 0, 0, 0, 0},boardStatus[6]);
    }

    @Test
    public void setChessBasic2() throws IllegalAccessException{
        assertTrue(board.setChess(1, 1));
        assertTrue(board.setChess(1, 2));
        int[][] boardStatus=(int[][]) boardArrayField.get(board);
        assertArrayEquals(new int[]{1, 2, 0, 0, 0, 0},boardStatus[1]);
    }

    @Test
    public void setChessBVT1() throws IllegalAccessException {
        assertFalse(board.setChess(-1, 1));
        int[][] boardStatus=(int[][]) boardArrayField.get(board);
        for(int[] column:boardStatus)assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0},column);
    }

    @Test
    public void setChessBVT2() throws IllegalAccessException {
        assertFalse(board.setChess(7, 1));
        int[][] boardStatus=(int[][]) boardArrayField.get(board);
        for(int[] column:boardStatus)assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0},column);}

    @Test
    public void setChessBVT3() throws IllegalAccessException {
        assertFalse(board.setChess(1, 0));
        int[][] boardStatus=(int[][]) boardArrayField.get(board);
        for(int[] column:boardStatus)assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0},column);}

    @Test
    public void setChessBVT4() throws IllegalAccessException {
        assertFalse(board.setChess(1, 3));
        int[][] boardStatus=(int[][]) boardArrayField.get(board);
        for(int[] column:boardStatus)assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0},column);
    }

    @Test
    public void getGameBoardTestBasic() throws IllegalAccessException {
        int[][] boardStatus=(int[][]) boardArrayField.get(board);
        int[][] returnedStatus=board.getGameBoard();
        assertArrayEquals(boardStatus,returnedStatus);
        //Hashcode differs for different memory location. So this judges deep-copy and shallow-copy.
        assertNotEquals(boardStatus.hashCode(),returnedStatus.hashCode());
    }

    @Test
    public void getGameBoardTestBasic1() throws IllegalAccessException{
        board.setChess(1,1);
        int[][] boardStatus=(int[][]) boardArrayField.get(board);
        int[][] returnedStatus=board.getGameBoard();
        assertArrayEquals(boardStatus,returnedStatus);
        //Hashcode differs for different memory location. So this judges deep-copy and shallow-copy.
        assertNotEquals(boardStatus.hashCode(),returnedStatus.hashCode());
    }

    @Test
    public void isFullBasic1() {
        assertFalse(board.isFull());
    }

    @Test
    public void isFullBasic2(){
        board.setChess(1,1);
        assertFalse(board.isFull());
    }
}