package sse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
            board.setChess(i%7,i%2);
        }
    }

    @After
    public void tearDown() throws Exception {
        board=null;
    }

    @Test
    public void setChess() {
        assertEquals(board.setChess(0,1),false);
    }

    @Test
    public void getGameBoard() {
    }

    @Test
    public void isFull() {
        assertEquals(board.isFull(),true);
    }
}
