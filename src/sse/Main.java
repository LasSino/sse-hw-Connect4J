package sse;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        GameController ctl=new GameController();
        ctl.displayGameboard();
        Thread.sleep(1000);
        ctl.setChess(0);
        ctl.displayGameboard();
        Thread.sleep(1000);
        ctl.setChess(0);
        ctl.displayGameboard();
        return;
    }
}
