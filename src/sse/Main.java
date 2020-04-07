package sse;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    GamePlayer p1=new ConsoleGamePlayer("Player 1");
	    GamePlayer p2=new ConsoleGamePlayer("Player 2");
	    GameController controller=new GameController(new ArrayBoard(),new ConsoleBoardRenderer(),p1,p2);
	    controller.gamePlay();
        System.out.println("Do you want to save the record to a file?(Y/N,default to N)");
        String response=(new Scanner(System.in)).nextLine();
        if(response.startsWith("y")||response.startsWith("Y")){
            try {
                GameRecordSaver.saveToFile(controller.getSetRecord(),p1.getPlayerName(),
                        p2.getPlayerName(),controller.getWinningState());
            } catch (IOException e) {
                System.out.println("Cannot save to file!");
            }
        }
        else{
            return;
        }
    }
}
