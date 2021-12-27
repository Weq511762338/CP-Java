//package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JustGreenEnough {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] farm = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                farm[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int[][] below = new int[n][n+1];
        int[][] atmost = new int[n][n+1];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                below[i][j+1] = below[i][j] + (farm[i][j] < 100 ? 1 : 0);
                atmost[i][j+1] = atmost[i][j] + (farm[i][j] <= 100 ? 1 : 0);
            }
        }

        long ans = 0;
        for (int x1 = 0; x1 < n; x1++) {
            for (int x2 = x1+1; x2 <= n; x2++) {
                int y1 = 0;
                int y2 = 0;

                for (int l = 0; l < n; l++) {
                    while(y1 < n &&(y1 < l || below[y1][x2] == below[y1][x1])) y1++;
                    while(y2 < n &&(y2 < l || atmost[y2][x2] == atmost[y2][x1])) y2++;

                    ans += y1 - y2;
                }
            }
        }
        System.out.println(ans);

    }
}
