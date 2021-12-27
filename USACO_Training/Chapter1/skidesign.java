/*
ID: weq51171
LANG: JAVA
TASK: skidesign
 */

//package USACO_Training;

import java.io.*;
import java.util.Arrays;

public class skidesign {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("skidesign.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));

        int n = Integer.parseInt(br.readLine());
        int[] height = new int[n];

        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        /*
        find the range where most mountains are within the range
        change the rest to the min and max to that range
         */

        Arrays.sort(height);
        int cost = 0;
        int min = 0;
        int max = 0;

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {// find the range that have the most count
            min = i;
            max = i + 17;
            for (int k = 0; k < n; k++) {
                if (height[k] < min)
                    cost += (min - height[k]) * (min - height[k]);
                if (height[k] > max)
                    cost += (height[k] - max) * (height[k] - max);
            }
            if (cost < ans)
                ans = cost;
            cost = 0;
        }


        pw.println(ans);
        pw.close();
    }
}
