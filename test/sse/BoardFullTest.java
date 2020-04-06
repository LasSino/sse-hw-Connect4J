package sse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

/**
 * This test tests the functions when the board is full.
 *
 * All test cases are based on a full board.
 */
public class BoardFullTest {
    Board board;

    @Before
    public void setUp() throws Exception {
        board=new Board();
        for(int i=0;i<42;i++){
            board.setChess(i%7,(i%2)+1);
        }
    }

    @After
    public void tearDown() throws Exception {
        board=null;
    }

    @Test
    public void setChessWhenFull() {
        int[][] boardArrayBefore=board.getGameBoard();
        assertFalse(board.setChess(1,1));
        assertArrayEquals(boardArrayBefore,board.getGameBoard());
    }

    @Test
    public void getGameBoard() throws NoSuchFieldException, IllegalAccessException {
        Field boardArrayField =board.getClass().getDeclaredField("gameBoard");
        boardArrayField.setAccessible(true);
        int[][] boardStatus=(int[][]) boardArrayField.get(board);
        int[][] returnedStatus=board.getGameBoard();
        assertArrayEquals(boardStatus,returnedStatus);
        //Hashcode differs for different memory location. So this judges deep-copy and shallow-copy.
        assertNotEquals(boardStatus.hashCode(),returnedStatus.hashCode());
    }

    @Test
    public void isFull() {
        assertTrue(board.isFull());
    }
}
