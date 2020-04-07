package sse;


/**
 * The controller class.
 * This class manages the control of the game board.
 * @author LTW
 */
public class GameController {
    private Board board;
    private int currentPlayer;
    private int lastColumnIndex;

    public GameController() {
        board=new Board();
        currentPlayer=1;
        lastColumnIndex=-1;
    }

    public boolean setChess(int column){
        boolean res=board.setChess(column, getCurrentPlayer());
        if(res){
            currentPlayer=((getCurrentPlayer() ==1)?2:1);
            lastColumnIndex=column;
        }
        displayGameboard();
        return res;
    }

    public void displayGameboard(){
        int[][] boardStatus=board.getGameBoard();
        for(int rowIndex=0;rowIndex<boardStatus[0].length;rowIndex++){
            System.out.print("|");
            for(int columnIndex=0;columnIndex<boardStatus.length;columnIndex++){
                String chessFigure;
                switch (boardStatus[columnIndex][rowIndex]){
                    case 1:chessFigure="●";break;
                    case 2:chessFigure="○";break;
                    default:chessFigure=" ";break;
                }
                System.out.print(chessFigure+"|");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Check whether last move leads to win.
     * @return True if last move leads to win, else false.
     */
    public boolean checkWinning(){
        int[][] boardStatus=board.getGameBoard();
        int[] lastColumn=boardStatus[lastColumnIndex];
        int lastRowIndex;
        for(lastRowIndex=0;lastRowIndex<lastColumn.length;lastRowIndex++){
            if(lastColumn[lastRowIndex]==0) break;
        }
        lastRowIndex--;//Now the last move (lastColumnIndex,lastRowIndex) is determined.
        int lastChess=boardStatus[lastColumnIndex][lastRowIndex];
        //Horizontal judge.
        int leftAdjacent,rightAdjacent;
        for(leftAdjacent=0;leftAdjacent<4;leftAdjacent++){
            if(lastColumnIndex-leftAdjacent-1<0) break;
            if (boardStatus[lastColumnIndex-leftAdjacent-1][lastRowIndex]!=lastChess) break;
        }
        for(rightAdjacent=0;rightAdjacent<4;rightAdjacent++){
            if(lastColumnIndex+rightAdjacent+1>=7) break;
            if(boardStatus[lastColumnIndex+rightAdjacent+1][lastRowIndex]!=lastChess)break;
        }
        if(leftAdjacent+rightAdjacent+1>=4) return true;

        //Vertical judge.
        if(lastRowIndex>=3){
            int verticalAdjacent;
            for (verticalAdjacent = 0; verticalAdjacent <4 ; verticalAdjacent++) {
                if(boardStatus[lastColumnIndex][lastRowIndex-verticalAdjacent-1]!=lastChess) break;
            }
            if(verticalAdjacent>=3) return true;
        }

        //Upper-left to lower-right diagonal judge.
        int ulAdjacent,lrAdjacent;
        for(ulAdjacent=0;ulAdjacent<4;ulAdjacent++){
            if((lastColumnIndex-ulAdjacent-1<0)||(lastRowIndex+ulAdjacent+1>=6)) break;
            if (boardStatus[lastColumnIndex-ulAdjacent-1][lastRowIndex+ulAdjacent+1]!=lastChess) break;
        }
        for(lrAdjacent=0;lrAdjacent<4;lrAdjacent++){
            if((lastColumnIndex+lrAdjacent+1>=7)||(lastRowIndex-lrAdjacent-1<0)) break;
            if(boardStatus[lastColumnIndex+lrAdjacent+1][lastRowIndex-lrAdjacent-1]!=lastChess)break;
        }
        if(ulAdjacent+lrAdjacent+1>=4) return true;

        //Upper-left to lower-right diagonal judge.
        int urAdjacent,llAdjacent;
        for(urAdjacent=0;urAdjacent<4;urAdjacent++){
            if((lastColumnIndex+urAdjacent+1>=7)||(lastRowIndex+urAdjacent+1>=6)) break;
            if (boardStatus[lastColumnIndex+urAdjacent+1][lastRowIndex+urAdjacent+1]!=lastChess) break;
        }
        for(llAdjacent=0;llAdjacent<4;llAdjacent++){
            if((lastColumnIndex-llAdjacent-1<0)||(lastRowIndex-llAdjacent-1<0)) break;
            if(boardStatus[lastColumnIndex-llAdjacent-1][lastRowIndex-llAdjacent-1]!=lastChess)break;
        }
        if(urAdjacent+llAdjacent+1>=4) return true;

        return false;
    }

    /**
     * This function checks whether the game has finished
     * @return the finish status.
     */
    public boolean isFinished(){
        if(checkWinning())return true;
        if(board.isFull()) return true;
        return false;
    }

    /**
     * Getter function that decides the current player.
     * @return current player.
     */
    public int getCurrentPlayer() {
        return currentPlayer;
    }
}
