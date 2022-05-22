import kickstart2022.roundB.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class p13 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.toString());
        int m = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][m+1];
        int[][] info = new int[n+1][3];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int ticket = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            info[i][0] = ticket;
            info[i][1] = day;
            info[i][2] = cost;
        }
        br.close();


    }
}
