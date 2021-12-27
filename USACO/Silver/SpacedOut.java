//package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SpacedOut {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
        int horizontal = 0;
        for(int i = 0; i < n; i++){
            int[] sum = new int[2];
            for (int j = 0; j < n; j++) {
                sum[j%2] += arr[i][j];
            }
            horizontal += Math.max(sum[0], sum[1]);
        }
        int verticle = 0;
        for(int i = 0; i < n; i++){
            int[] sum = new int[2];
            for (int j = 0; j < n; j++) {
                sum[j%2] += arr[j][i];
            }
            verticle += Math.max(sum[0], sum[1]);
        }

        pw.println(Math.max(horizontal, verticle));
        pw.close();
    }
}
