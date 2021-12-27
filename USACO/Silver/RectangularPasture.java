//package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class RectangularPasture {

    static int[][] sums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        int[] xs = new int[n];
        int[] ys = new int[n];
        Integer[] cow = new Integer[n];

        for (int i = 0; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xs[i] = x;
            ys[i] = y;
            cow[i] = i;
        }
        br.close();
        Arrays.sort(cow, Comparator.comparingInt(a -> xs[a]));
        for(int i = 1; i <= n ; i ++){
            xs[cow[i-1]] = i;
        }
        Arrays.sort(cow, Comparator.comparingInt(a -> ys[a]));
        for(int i = 1; i <= n ; i ++){
            ys[cow[i-1]] = i;
        }
        sums = new int[n+1][n+1];
        for (int i = 0; i < n; i++) {
            sums[xs[i]][ys[i]]++;
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i > 0)
                    sums[i][j] += sums[i-1][j];
                if (j > 0)
                    sums[i][j] += sums[i][j-1];
                if (i > 0 && j > 0)
                    sums[i][j] -= sums[i-1][j-1];
            }
        }
        long ans = n + 1;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                ans += getSum(Math.min(xs[j], xs[i]), Math.max(xs[j], xs[i]), 1, Math.min(ys[j], ys[i]))
                        *getSum(Math.min(xs[j], xs[i]), Math.max(xs[j], xs[i]), Math.max(ys[j], ys[i]), n);
            }
        }
        pw.println(ans);
        pw.close();
    }

    public static int getSum(int fromx,int tox, int fromy, int toy){
        return sums[tox][toy] - sums[fromx-1][toy] - sums[tox][fromy-1] + sums[fromx-1][fromy-1];
    }
}
