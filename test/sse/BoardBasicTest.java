package sse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This test tests the basic functions of the {@code: Board} class.
 *
 * All the test cases are ran on a empty board.
 */
public class BoardBasicTest {
    Board board;

    @Before
    public void setUp() throws Exception {
        board=new Board();
    }

    @After
    public void tearDown() throws Exception {
        board=null;
    }

    @Test
    public void setChessBasic() {
        assertEquals(board.setChess(1,1),true);
    }

    @Test
    public void setChessBVT1(){assertEquals(board.setChess(-1,1),false);}

    @Test
    public void setChessBVT2(){assertEquals(board.setChess(7 ,1),false);}

    @Test
    public void setChessBVT3(){assertEquals(board.setChess(1,0),false);}

    @Test
    public void setChessBVT4(){assertEquals(board.setChess(1,3),false);}

    @Test
    public void getGameBoard() {
    }

    @Test
    public void isFull() {
    }
}