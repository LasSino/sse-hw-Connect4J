package sse;

import java.util.Scanner;

public class ConsoleGamePlayer implements GamePlayer {

    private String playerName;
    private String playerIdentifier;
    private Scanner sc;

    public ConsoleGamePlayer(String playerIdentifier){
        this.playerIdentifier=playerIdentifier;
        sc=new Scanner(System.in);
        playerName="";
        setPlayerName();
    }

    private void setPlayerName(){
        System.out.println("Please input the name for "+playerIdentifier);
        playerIdentifier=sc.nextLine();
    }

    @Override
    public String getPlayerName() {
        return (playerName.equals("")?playerIdentifier:playerName);
    }

    @Override
    public int getNextChessSetPosition(ChessTypeEnum[][] boardStatus) {
        System.out.print(getPlayerName()+", please input next column index you want to set chess: ");
        while(sc.hasNext()&&!sc.hasNextInt()){
            sc.next();
            System.out.print("Please input a number:");
        }
        return sc.nextInt();
    }
}
