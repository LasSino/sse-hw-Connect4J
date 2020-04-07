package sse;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameJudgeTest {

    @Test
    public void checkWinningPCT1()  {
        ChessTypeEnum[][] boardStatus=new ChessTypeEnum[][]{
                {ChessTypeEnum.player1Chess,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.player1Chess,ChessTypeEnum.player2Chess,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.player1Chess,ChessTypeEnum.player2Chess,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.player1Chess,ChessTypeEnum.player2Chess,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}
        };
        assertTrue(GameJudge.winningState(boardStatus,0));
    }

    @Test
    public void checkWinningPCT2()  {
        ChessTypeEnum[][] boardStatus=new ChessTypeEnum[][]{
                {ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.player1Chess,ChessTypeEnum.player1Chess,ChessTypeEnum.player1Chess,ChessTypeEnum.player1Chess,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.player2Chess,ChessTypeEnum.player2Chess,ChessTypeEnum.player2Chess,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}
        };
        assertTrue(GameJudge.winningState(boardStatus,1));
    }

    @Test
    public void checkWinningPCT3() {
        ChessTypeEnum[][] boardStatus=new ChessTypeEnum[][]{
                {ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.player1Chess,ChessTypeEnum.player2Chess,ChessTypeEnum.player2Chess,ChessTypeEnum.player1Chess,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.player1Chess,ChessTypeEnum.player2Chess,ChessTypeEnum.player1Chess,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.player1Chess,ChessTypeEnum.player1Chess,ChessTypeEnum.player2Chess,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.player1Chess,ChessTypeEnum.player2Chess,ChessTypeEnum.player2Chess,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}
        };
        assertTrue(GameJudge.winningState(boardStatus,1));
    }

    @Test
    public void checkWinningPCT4() throws IllegalAccessException {
        ChessTypeEnum[][] boardStatus=new ChessTypeEnum[][]{
                {ChessTypeEnum.player1Chess,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.player2Chess,ChessTypeEnum.player1Chess,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.player1Chess,ChessTypeEnum.player2Chess,ChessTypeEnum.player1Chess,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.player1Chess,ChessTypeEnum.player2Chess,ChessTypeEnum.player2Chess,ChessTypeEnum.player1Chess,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.player2Chess,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}
        };
        assertTrue(GameJudge.winningState(boardStatus,0));
    }

    @Test
    public void checkWinningPCT5() throws IllegalAccessException {
        ChessTypeEnum[][] boardStatus=new ChessTypeEnum[][]{
                {ChessTypeEnum.player1Chess,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.player1Chess,ChessTypeEnum.player2Chess,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.player2Chess,ChessTypeEnum.player1Chess,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.player1Chess,ChessTypeEnum.player2Chess,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}, {ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder,ChessTypeEnum.placeHolder}
        };
        assertFalse(GameJudge.winningState(boardStatus,0));
    }
}