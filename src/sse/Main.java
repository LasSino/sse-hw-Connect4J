package sse;

import java.util.Scanner;

/**
 * The main class.
 * This class contains the main entry.
 * @author LTW
 */
public class Main {

    public static void main(String[] args) {
        GameController ctl=new GameController();
        Scanner sc=new Scanner(System.in);
        System.out.println("Connect4 game, by HUST SSE1701 Group 2.");
        do {
            System.out.println("Please input the next column (Player "+ctl.getCurrentPlayer()+" ).");
            ctl.setChess(sc.nextInt());
        }while(!ctl.isFinished());
        if(!ctl.checkWinning()){
            System.out.println("Draw!");
        }else{
            System.out.println("Player "+((ctl.getCurrentPlayer()==1)?2:1)+" won!");
        }
        return;
    }
}
