/*
ID: weq51171
LANG: JAVA
TASK: ride
 */
//package USACO_Training;
import java.io.*;

public class ride {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("ride.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

        byte[] comet = br.readLine().getBytes();
        byte[] name = br.readLine().getBytes();
        br.close();
        int countComet = 1;
        int countName = 1;

        for (int i = 0; i < comet.length; i++){
            countComet *= comet[i]-64;
        }
        for (int i = 0; i < name.length; i++){
             countName *= name[i]-64;
        }
        if (countComet%47 == countName%47)
            pw.println("GO");
        else
            pw.println("STAY");

        pw.close();
    }
}
