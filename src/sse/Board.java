package sse;

public interface Board {
    public static final int ROW_SIZE=7;
    public static final int COL_SIZE=6;
    boolean setChess(int columnNumber,ChessTypeEnum chess);
    ChessTypeEnum[][] getBoardStatus();
}
