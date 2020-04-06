package sse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
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
    public void setChess() {
        assertEquals(board.setChess(11,1),false);
    }

    @Test
    public void getGameBoard() {
    }

    @Test
    public void isFull() {
    }
}