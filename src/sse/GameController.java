package sse;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private Board gameBoard;
    private BoardRenderer renderer;
    private GamePlayer player1,player2,nextPlayer;
    private ChessTypeEnum nextChess;
    private ArrayList<Integer> setRecord;
    private String winningState;

    public GameController(Board gameBoard,BoardRenderer renderer,GamePlayer player1,GamePlayer player2){
        this.gameBoard=gameBoard;
        this.renderer=renderer;
        this.player1=player1;
        this.player2=player2;
        nextPlayer=player1;
        nextChess=ChessTypeEnum.player1Chess;
        setRecord=new ArrayList<>();
        winningState="Game not finished";
    }

    public void gamePlay(){
        System.out.println("The game starts.");
        renderer.displayBoard(gameBoard.getBoardStatus());
        while(setRecord.isEmpty()||!GameJudge.isFinished(gameBoard.getBoardStatus(),setRecord.get(setRecord.size()-1))){
            setNextChess();
        }
        System.out.print("Game ended!");
        if(GameJudge.winningState(gameBoard.getBoardStatus(),setRecord.get(setRecord.size()-1))){
            //The last move leads to winning.
            GamePlayer winningPlayer=((nextChess==ChessTypeEnum.player1Chess)?player2:player1);
            winningState=winningPlayer.getPlayerName()+" won!";
        }else{
            //Draw.
            winningState="Draw";
        }
        System.out.println(getWinningState());
    }

    private boolean setNextChess(){
        int nextColumnIndex=this.nextPlayer.getNextChessSetPosition(gameBoard.getBoardStatus());
        if(gameBoard.setChess(nextColumnIndex,nextChess)){
            this.nextPlayer=(nextChess==ChessTypeEnum.player1Chess)?player2:player1;
            this.nextChess=(nextChess==ChessTypeEnum.player1Chess)?ChessTypeEnum.player2Chess:ChessTypeEnum.player1Chess;
            this.setRecord.add(nextColumnIndex);
            renderer.displayBoard(gameBoard.getBoardStatus());
            return true;
        }else {
            System.out.println("Invalid input, please try again!");
            renderer.displayBoard(gameBoard.getBoardStatus());
            return false;
        }
    }

    public List<Integer> getSetRecord(){
        return List.copyOf(setRecord);
    }

    public String getWinningState() {
        return winningState;
    }
}
