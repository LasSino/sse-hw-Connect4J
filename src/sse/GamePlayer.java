package sse;

public interface GamePlayer {
    String getPlayerName();
    int getNextChessSetPosition(ChessTypeEnum[][] boardStatus);
}
