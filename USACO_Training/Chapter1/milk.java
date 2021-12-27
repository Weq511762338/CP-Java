/*
ID: weq51171
LANG: JAVA
TASK: milk
 */

//package USACO_Training;

import java.io.*;
import java.util.StringTokenizer;

public class milk {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("milk.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] price = new int[m];
        int[] amount =  new int[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            price[i] = Integer.parseInt(st.nextToken());
            amount[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int minCost = 0;
        int[][] result = insertionSort(price, amount);
        price = result[0];
        amount = result[1];

        int i = 0;
        if (m != 0) {
            while (amount[i] < n) {
                minCost += price[i] * amount[i];
                n -= amount[i];
                i++;
            }
            minCost += price[i] * n;
        }

        pw.println(minCost);
        pw.close();
    }

    public static int[][] insertionSort(int[] a, int[] b){
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                    int t2 = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = t2;
                }
            }
        }
        int[][] result = new int[2][a.length];
        result[0] = a;
        result[1] = b;
        return  result;
    }
}
