/*
ID: weq51171
LANG: JAVA
TASK: barn1
 */

//package USACO_Training;

import java.io.*;
import java.util.*;

public class barn1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("barn1.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] cow = new int [c];
        HashMap<Integer, Integer> dif = new HashMap<>();
        int[] dif2 = new int [c-1];

        for (int i = 0; i < c; i++) {
            cow[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(cow);
        for (int i = 0; i < c; i++) {
            if (i != 0) {
                dif.put(cow[i] - cow[i - 1], i - 1);
                dif2[i-1] = cow[i] - cow[i - 1];
            }
        }
        br.close();
        Arrays.sort(dif2);

        int ans = 0;
        if (m >= c)
            ans = c;
        else {
            ArrayList<Integer> stall = new ArrayList<>();
            for (int i = dif2.length - 1; i >= dif2.length-m+1; i--)
                stall.add(0, dif.get(dif2[i]));


            if (stall.size() != 0) {
                Collections.sort(stall);
                ans += cow[stall.get(0)] - cow[0] + 1;
                for (int i = 0; i < stall.size() - 1; i++) {
                    ans += cow[stall.get(i + 1)] - cow[stall.get(i) + 1] + 1;
                }
                ans += cow[c - 1] - cow[stall.get(stall.size() - 1) + 1] + 1;
            } else
                ans = cow[c-1] - cow[0] + 1;
        }
        pw.println(ans);
        pw.close();

    }
}
