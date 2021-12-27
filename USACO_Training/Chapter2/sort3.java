/*
ID: weq51171
LANG: JAVA
TASK: sort3
 */

//package USACO_Training.Chapter2;

import java.io.*;
import java.util.Arrays;

public class sort3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sort3.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sorted = new int[n];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            sorted[i] = num;
        }

        br.close();

        int ans = 0;

        Arrays.sort(sorted);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && arr[i] == sorted[j] && arr[j] == sorted[i] && arr[i] != sorted[i]){
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                    ans++;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i]!=sorted[i])
                count ++;
        }
        ans += count/3*2;
        pw.println(ans);
        pw.close();
        /*
        sort the one that can be done by exchanging once
        finish the rest with 2 exchange(at most 3 differences)
         */
    }
}
