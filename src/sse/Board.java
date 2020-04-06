package sse;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Class {@code Board} is the model for a Connect 4 game board.
 * This class manages the storage of the game board status, also provides fucntion to place the chesses.
 */
public class Board {
    /**
     * The two-dimensional array mocks a game board.
     * To better use the array, each inner array represents a column,
     * while each int in the inner array represents the checker in the column.
     * i.e. to access a checker in row R, col C, the checker is gameBoard[C][R].
     *
     * To mock the top and bottom in the actual game,
     * we make it a conservation that the smaller index represents the bottom.
     */
    private int[][] gameBoard;

    private static int rowSize=7; //There are 7 columns in a row.
    private static int colSize=6; //There are 6 rows in a column.
    private static int placeHolder=0;
    private static int player1Chess=1;
    private static int player2Chess=2;

    /**
     * The constructor for the game board.
     * The storage is initialized here and all checkers are set to empty.
     */
    public Board(){
        this.gameBoard=new int[rowSize][colSize];
        for (int[] column:gameBoard) {
            for (int rowIndex = 0; rowIndex < colSize; rowIndex++) {
                column[rowIndex]=placeHolder;
            }
        }
    }

    /**
     * The function to set a chess on the board.
     * @param columnNumber The column on which the chess is set, which should range in [0,colSize)
     * @param chessNumber The type of chess to be set
     * @return If the chess is set successfully, return true. Otherwise returns false.
     */
    public boolean setChess(int columnNumber,int chessNumber){
        if(columnNumber<0||columnNumber>=colSize){//The column number is invalid.
            return false;
        }
        if((chessNumber!=1)&&(chessNumber!=2)) return false;//The chess number is invalid.
        int[] column=gameBoard[columnNumber];
        if(column[colSize-1]>0) return false;//The column is full so the operation failed.
        for(int index=0;index<colSize;index++){//Drop the chess to the bottommost row.
            if(column[index]==0) column[index]=chessNumber;
            break;
        }
        return true; //The chess is successfully set.
    }

    /**
     * Return a game board array.
     * The array is a deep copy in case the user should change it.
     * @return a deep copy of the current gameBoard
     */
    public int[][] getGameBoard(){
        int[][] deepCopy=new int[rowSize][colSize];
        for(int colIndex=0;colIndex<rowSize;colIndex++)
            for (int rowIndex=0;rowIndex<colSize;rowIndex++) deepCopy[colIndex][rowIndex]=this.gameBoard[colIndex][rowIndex];
        return  deepCopy;
    }

    public boolean isFull(){
        boolean full=true;
        for (int[] column:gameBoard) {
            full=(full&&(column[colSize-1]!=0));
        }
        return full;
    }
}
