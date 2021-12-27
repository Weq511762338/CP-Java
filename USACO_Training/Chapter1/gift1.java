/*
ID: weq51171
LANG: JAVA
TASK: gift1
 */
package USACO_Training;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class gift1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int np = Integer.parseInt(st.nextToken());
        int[] account = new int[np];
        ArrayList<String> name = new ArrayList<>();
        for (int i = 0; i < np; i++) {
            st = new StringTokenizer(br.readLine());
            name.add(st.nextToken());
        }

        for (int i = 0; i < np; i++) {
            st = new StringTokenizer(br.readLine());
            int giver = name.indexOf(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int moneyGive = Integer.parseInt(st.nextToken());
            int receiver = Integer.parseInt(st.nextToken());
            if(receiver != 0) {
                account[giver] = account[giver] - moneyGive + moneyGive % receiver;
                for (int j = 0; j < receiver; j++) {
                    st = new StringTokenizer(br.readLine());
                    account[name.indexOf(st.nextToken())] += moneyGive / receiver;
                }
            }
        }

        for (int i = 0; i < np; i++) {
            pw.println(name.get(i) + " " + account[i]);
        }
        pw.close();

    }
}
