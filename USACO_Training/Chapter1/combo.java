/*
ID: weq51171
TASK: combo
LANG: JAVA
 */


//package USACO_Training;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class combo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("combo.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));

        int n = Integer.parseInt(br.readLine());
        int[] farmer = new int[3];
        int[] maker = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        farmer[0] = Integer.parseInt(st.nextToken()) - 2;
        farmer[1] = Integer.parseInt(st.nextToken()) - 2;
        farmer[2] = Integer.parseInt(st.nextToken()) - 2;

        st = new StringTokenizer(br.readLine());
        maker[0] = Integer.parseInt(st.nextToken()) - 2;
        maker[1] = Integer.parseInt(st.nextToken()) - 2;
        maker[2] = Integer.parseInt(st.nextToken()) - 2;

        br.close();

        ArrayList<String> list = new ArrayList<>();
        /*
        Generate the 5 numbers for each combination
        for loop
        do same thing again for maker
         */
        for (int i = 0; i < 3; i++) {
            if (farmer[i] <= 0)
                farmer[i] += n;
            if (maker[i] <= 0)
                maker[i] += n;
        }
        for (int i = 0; i < 5; i++) {
            int com1 = farmer[0] + i;
            if (com1 > n)
                com1 -= n;
            if (com1 > n || com1 < 1)
                continue;
            for (int j = 0; j < 5; j++) {
                int com2 = farmer[1] + j;
                if (com2 > n)
                    com2 -= n;
                if (com2 > n || com2 < 1)
                    continue;

                for (int k = 0; k < 5; k++) {
                    int com3 = farmer[2] + k;
                    if (com3 > n)
                        com3 -= n;
                    if (com3 > n || com3 < 1)
                        continue;

                    if(list.contains("" + com1 + com2 + com3) == false)
                        list.add("" + com1 + com2 + com3);
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            int com1 = maker[0] + i;
            if (com1 > n)
                com1 -= n;
            if (com1 > n || com1 < 1)
                continue;

            for (int j = 0; j < 5; j++) {
                int com2 = maker[1] + j;
                if (com2 > n)
                    com2 -= n;
                if (com2 > n || com2 < 1)
                    continue;

                for (int k = 0; k < 5; k++) {
                    int com3 = maker[2] + k;
                    if (com3 > n)
                        com3 -= n;
                    if (com3 > n || com3 < 1)
                        continue;

                    if(list.contains("" + com1 + com2 + com3) == false)
                        list.add("" + com1 + com2 + com3);
                }
            }
        }


        pw.println(list.size());
        pw.close();

    }
}
