package sse;

public class GameJudge{
    public static final int SUCCESS_CONDITION=4;

    private static boolean isBoardFull(ChessTypeEnum[][] boardStatus){
        boolean full=true;
        for (ChessTypeEnum[] column:boardStatus) {
            full=(full&&(column[Board.COL_SIZE-1]!=ChessTypeEnum.placeHolder));
        }
        return full;
    }

    public static boolean isFinished(ChessTypeEnum[][] boardStatus,int lastSetColumn) {
        return (winningState(boardStatus,lastSetColumn)||isBoardFull(boardStatus));
    }

    public static boolean winningState(ChessTypeEnum[][] boardStatus, int lastSetColumn) {
        if (lastSetColumn==-1) return false;
        ChessTypeEnum[] lastColumn=boardStatus[lastSetColumn];
        int lastRowIndex;
        for(lastRowIndex=0;lastRowIndex<lastColumn.length;lastRowIndex++){
            if(lastColumn[lastRowIndex]==ChessTypeEnum.placeHolder) break;
        }
        lastRowIndex--;//Now the last move (lastColumnIndex,lastRowIndex) is determined.
        ChessTypeEnum lastChess=boardStatus[lastSetColumn][lastRowIndex];
        //Horizontal judge.
        int leftAdjacent,rightAdjacent;
        for(leftAdjacent=0; leftAdjacent< SUCCESS_CONDITION-1; leftAdjacent++){
            if(lastSetColumn-leftAdjacent-1<0) break;
            if (boardStatus[lastSetColumn-leftAdjacent-1][lastRowIndex]!=lastChess) break;
        }
        for(rightAdjacent=0;rightAdjacent<SUCCESS_CONDITION-1;rightAdjacent++){
            if(lastSetColumn+rightAdjacent+1>=Board.ROW_SIZE) break;
            if(boardStatus[lastSetColumn+rightAdjacent+1][lastRowIndex]!=lastChess)break;
        }
        if(leftAdjacent+rightAdjacent+1>=SUCCESS_CONDITION) return true;

        //Vertical judge.
        if(lastRowIndex>=3){
            int verticalAdjacent;
            for (verticalAdjacent = 0; verticalAdjacent <SUCCESS_CONDITION-1 ; verticalAdjacent++) {
                if(boardStatus[lastSetColumn][lastRowIndex-verticalAdjacent-1]!=lastChess) break;
            }
            if(verticalAdjacent+1>=SUCCESS_CONDITION) return true;
        }

        //Upper-left to lower-right diagonal judge.
        int ulAdjacent,lrAdjacent;
        for(ulAdjacent=0;ulAdjacent<SUCCESS_CONDITION-1;ulAdjacent++){
            if((lastSetColumn-ulAdjacent-1<0)||(lastRowIndex+ulAdjacent+1>=Board.COL_SIZE)) break;
            if (boardStatus[lastSetColumn-ulAdjacent-1][lastRowIndex+ulAdjacent+1]!=lastChess) break;
        }
        for(lrAdjacent=0;lrAdjacent<SUCCESS_CONDITION-1;lrAdjacent++){
            if((lastSetColumn+lrAdjacent+1>=Board.ROW_SIZE)||(lastRowIndex-lrAdjacent-1<0)) break;
            if(boardStatus[lastSetColumn+lrAdjacent+1][lastRowIndex-lrAdjacent-1]!=lastChess)break;
        }
        if(ulAdjacent+lrAdjacent+1>=SUCCESS_CONDITION) return true;

        //Upper-left to lower-right diagonal judge.
        int urAdjacent,llAdjacent;
        for(urAdjacent=0;urAdjacent<SUCCESS_CONDITION-1;urAdjacent++){
            if((lastSetColumn+urAdjacent+1>=Board.ROW_SIZE)||(lastRowIndex+urAdjacent+1>=Board.COL_SIZE)) break;
            if (boardStatus[lastSetColumn+urAdjacent+1][lastRowIndex+urAdjacent+1]!=lastChess) break;
        }
        for(llAdjacent=0;llAdjacent<SUCCESS_CONDITION-1;llAdjacent++){
            if((lastSetColumn-llAdjacent-1<0)||(lastRowIndex-llAdjacent-1<0)) break;
            if(boardStatus[lastSetColumn-llAdjacent-1][lastRowIndex-llAdjacent-1]!=lastChess)break;
        }
        if(urAdjacent+llAdjacent+1>=SUCCESS_CONDITION) return true;

        return false;
    }
}
