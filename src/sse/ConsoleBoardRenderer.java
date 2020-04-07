package sse;

public class ConsoleBoardRenderer implements BoardRenderer {
    private static final String player1ChessFigure="●\t";
    private static final String player2ChessFigure="○\t";
    private static final String placeHolderFigure="\t";

    public ConsoleBoardRenderer(){

    }

    @Override
    public void displayBoard(ChessTypeEnum[][] boardStatus) {
        for(int rowIndex=boardStatus[0].length-1;rowIndex>=0;rowIndex--){
            System.out.print("|");
            for(int columnIndex=0;columnIndex<boardStatus.length;columnIndex++){
                String chessFigure="";
                switch (boardStatus[columnIndex][rowIndex]){
                    case player1Chess:chessFigure=player1ChessFigure;break;
                    case player2Chess:chessFigure=player2ChessFigure;break;
                    case placeHolder:chessFigure=placeHolderFigure;break;
                }
                System.out.print(chessFigure+"|");
            }
            System.out.println();
        }
        System.out.println();
    }
}
