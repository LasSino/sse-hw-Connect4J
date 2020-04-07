package sse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayBoardTest {

    Board board;
    @Before
    public void setUp() throws Exception {
        board=new ArrayBoard();
    }

    @After
    public void tearDown() throws Exception {
        board=null;
    }

    @Test
    public void setChessBasic() throws IllegalAccessException {
        assertTrue(board.setChess(6, ChessTypeEnum.player1Chess));
        ChessTypeEnum[][] boardStatus=board.getBoardStatus();
        assertArrayEquals(new ChessTypeEnum[]{ChessTypeEnum.player1Chess, ChessTypeEnum.placeHolder, ChessTypeEnum.placeHolder, ChessTypeEnum.placeHolder, ChessTypeEnum.placeHolder, ChessTypeEnum.placeHolder},boardStatus[6]);
    }

    @Test
    public void setChessBasic2() throws IllegalAccessException{
        assertTrue(board.setChess(1, ChessTypeEnum.player1Chess));
        assertTrue(board.setChess(1, ChessTypeEnum.player2Chess));
        ChessTypeEnum[][] boardStatus=board.getBoardStatus();
        assertArrayEquals(new ChessTypeEnum[]{ChessTypeEnum.player1Chess, ChessTypeEnum.player2Chess, ChessTypeEnum.placeHolder, ChessTypeEnum.placeHolder, ChessTypeEnum.placeHolder, ChessTypeEnum.placeHolder},boardStatus[1]);
    }

    @Test
    public void setChessBVT1() throws IllegalAccessException {
        assertFalse(board.setChess(-1, ChessTypeEnum.player1Chess));
        ChessTypeEnum[][] boardStatus=board.getBoardStatus();
        for(ChessTypeEnum[] column:boardStatus)assertArrayEquals(new ChessTypeEnum[]{ChessTypeEnum.placeHolder, ChessTypeEnum.placeHolder, ChessTypeEnum.placeHolder, ChessTypeEnum.placeHolder, ChessTypeEnum.placeHolder, ChessTypeEnum.placeHolder},column);
    }

    @Test
    public void setChessBVT2() throws IllegalAccessException {
        assertFalse(board.setChess(7, ChessTypeEnum.player1Chess));
        ChessTypeEnum[][] boardStatus=board.getBoardStatus();
        for(ChessTypeEnum[] column:boardStatus)assertArrayEquals(new ChessTypeEnum[]{ChessTypeEnum.placeHolder, ChessTypeEnum.placeHolder, ChessTypeEnum.placeHolder, ChessTypeEnum.placeHolder, ChessTypeEnum.placeHolder, ChessTypeEnum.placeHolder},column);
    }

}