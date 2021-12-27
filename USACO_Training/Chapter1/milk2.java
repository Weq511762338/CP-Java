/*
ID: weq51171
TASK: milk2
LANG: JAVA
 */

//package USACO_Training;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class milk2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        int n = Integer.parseInt(br.readLine());

        int[][] milk = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            milk[i][0] = Integer.parseInt(st.nextToken());
            milk[i][1] = Integer.parseInt(st.nextToken());
        }

        int interval = 0;
        int idle = 0;
        sort(milk);


        if(n == 1){
            interval = milk[0][1] - milk[0][0];
            idle = 0;
        }else {
            for (int i = 0; i < n - 1; i++) {
                if (milk[i + 1][0] <= milk[i][1] && milk[i + 1][0] >= milk[i][0]) {
                    int begin = milk[i][0];
                    int end = milk[i][1];
                    while (i < n - 1) {
                        if (milk[i + 1][1] < end) {
                            if (interval < end - begin)
                                interval = end - begin;
                        } else if (milk[i + 1][0] <= end && milk[i + 1][0] >= begin)
                            end = milk[i + 1][1];
                        else {
                            if (interval < end - begin)
                                interval = end - begin;
                            break;
                        }
                        i++;
                    }
                }
                if (i < n - 1) {
                    if (milk[i + 1][0] - milk[i][1] > idle) {
                        boolean valid = true;
                        for (int j = 0; j < n; j++) {
                            if ((milk[j][0] < milk[i + 1][0] && milk[j][0] > milk[i][1]) || (milk[j][1] < milk[i + 1][0] && milk[j][1] > milk[i][1]) || (milk[j][0] < milk[i][1] && milk[j][1] > milk[i + 1][0])) {
                                valid = false;
                                break;
                            }
                        }
                        if (valid)
                            idle = milk[i + 1][0] - milk[i][1];
                    }
                    if (milk[i][1] - milk[i][0] > interval || milk[i + 1][1] - milk[i + 1][0] > interval)
                        interval = Math.max(milk[i][1] - milk[i][0], milk[i + 1][1] - milk[i + 1][0]);
                }
            }
        }

        pw.println(interval + " " + idle);
        pw.close();
    }

    public static void sort (int[][] array){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j >= 1 ; j--) {
                if (array[j - 1][0] > array[j][0]) {
                    int t0 = array[j][0];
                    array[j][0] = array[j-1][0];
                    array[j-1][0] = t0;
                    int t1 = array[j][1];
                    array[j][1] = array[j-1][1];
                    array[j-1][1] = t1;
                }
            }
        }
    }

}