package sse;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class GameRecordSaver {
    public static void saveToFile(List<Integer> record,String player1Name,String player2Name,String gameResult) throws IOException {
        System.out.println("Please input the file you want to save to:");
        String filename=(new Scanner(System.in)).nextLine();
        FileOutputStream os=new FileOutputStream(filename);
        PrintWriter writer=new PrintWriter(new OutputStreamWriter(os));
        for(int i=0;i<record.size();i++){
            String recordLine=(((i%2)==0)?player1Name:player2Name) + " set chess at "+ record.get(i);
            writer.println(recordLine);
        }
        writer.println(gameResult);
        writer.close();
        os.close();
    }
}
