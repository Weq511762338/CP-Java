//package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class p3 {
    static int ans = 0;
    static int k;
    static int n;
    static boolean[][] hasBale;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());


        for(int i = 0 ; i < t; i++){
            ans = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            hasBale = new boolean[n][n];

            for(int j = 0 ; j < n; j++){
                String str = br.readLine();
                for (int l = 0; l < n; l++) {
                    char c = str.charAt(l);
                    if (c == 'H') hasBale[j][l] = true;
                }
            }

            run(1, 0, 'D', k);
            run(0, 1, 'R', k);
            pw.println(ans);
        }
        br.close();
        pw.close();

    }

    public static void run (int i, int j, char dir, int remainingTurn){
        if (remainingTurn < 0) return;
        if (i == n-1 && j == n-1){
            ans ++;
            return;
        }
        if (hasBale[i][j]){
            return;
        }
        if (dir == 'D'){
            if (i < n-1)
                run(i+1, j, dir, remainingTurn);
            if (j < n-1)
                run(i, j+1, 'R', remainingTurn-1);
        }
        if (dir == 'R'){
            if (j < n-1)
                run(i, j+1, dir, remainingTurn);
            if (i < n-1)
                run(i+1, j, 'D', remainingTurn-1);
        }
    }
}
