package sse;


public class GameController {
    private Board board;
    private int currentPlayer;

    public GameController() {
        board=new Board();
        currentPlayer=1;
    }

    public boolean setChess(int column){
        boolean res=board.setChess(column,currentPlayer);
        currentPlayer=((currentPlayer==1)?2:1);
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
    }

    public int checkWinningStatus(int lastColumnIndex){
        int[][] boardStatus=board.getGameBoard();
        int[] lastColumn=boardStatus[lastColumnIndex];
        int lastRowIndex;
        for(lastRowIndex=0;lastRowIndex<lastColumn.length;lastRowIndex++){
            if(lastColumn[lastRowIndex]==0) break;
        }
        lastRowIndex--;
        //TODO: Insert logic code here.
        return 0;
    }
}
