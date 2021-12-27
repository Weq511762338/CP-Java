package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class paintbarn {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("paintbarn.in"));
//        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[1001][1001];
        for(int i = 0; i < n; i++){
            st= new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            arr[x1][y1] ++;
            arr[x2][y2] ++;
            arr[x1][y2] --;
            arr[x2][y1] --;
        }
        br.close();
        int ans = 0;
        for (int i = 0; i <= 1000; i++) {
            for (int j = 0; j <= 1000; j++) {
                if (i > 0) arr[i][j] += arr[i-1][j];
                if (j > 0) arr[i][j] += arr[i][j-1];
                if (i > 0 && j > 0) arr[i][j] -= arr[i-1][j-1];
                if (arr[i][j] == k) ans++;
            }
        }

        pw.println(ans);
        pw.close();
    }
}
