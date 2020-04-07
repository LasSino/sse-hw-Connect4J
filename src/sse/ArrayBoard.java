package sse;

public class ArrayBoard implements Board{

    /**
     * The two-dimensional array mocks a game board.
     * To better use the array, each inner array represents a column,
     * while each int in the inner array represents the checker in the column.
     * i.e. to access a checker in row R, col C, the checker is gameBoard[C][R].
     *
     * To mock the top and bottom in the actual game,
     * we make it a conservation that the smaller index represents the bottom.
     */
    protected ChessTypeEnum[][] gameBoard;

    public ArrayBoard(){
        this.gameBoard=new ChessTypeEnum[ROW_SIZE][COL_SIZE];
        for (ChessTypeEnum[] column:gameBoard) {
            for (int rowIndex = 0; rowIndex < COL_SIZE; rowIndex++) {
                column[rowIndex]=ChessTypeEnum.placeHolder;
            }
        }
    }

    @Override
    public boolean setChess(int columnNumber, ChessTypeEnum chess) {
        if(columnNumber<0||columnNumber>=ROW_SIZE){//The column number is invalid.
            return false;
        }
        if(chess==ChessTypeEnum.placeHolder) return false;//It is invalid to set a place holder.
        ChessTypeEnum[] column=gameBoard[columnNumber];
        if(column[COL_SIZE-1]!=ChessTypeEnum.placeHolder) return false;//The column is full so the operation failed.
        for(int index=0;index<COL_SIZE;index++){//Drop the chess to the bottommost row.
            if(column[index]==ChessTypeEnum.placeHolder) {
                column[index]=chess;
                break;
            }
        }
        return true; //The chess is successfully set.
    }

    @Override
    public ChessTypeEnum[][] getBoardStatus() {
        ChessTypeEnum[][] deepCopy=new ChessTypeEnum[ROW_SIZE][COL_SIZE];
        for(int colIndex=0;colIndex<ROW_SIZE;colIndex++)
            for (int rowIndex=0;rowIndex<COL_SIZE;rowIndex++) deepCopy[colIndex][rowIndex]=this.gameBoard[colIndex][rowIndex];
        return  deepCopy;
    }
}
