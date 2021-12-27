//package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ComfortableCows {
    static boolean[][] hasCow = new boolean[3000][3000];
    static int[][] adj = new int[3000][3000];
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb =new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            add(x+1000, y+1000);
            ans--;
            sb.append(ans + "\n");
//            sb.append(ans).append(System.lineSeparator());
        }
        br.close();
        pw.print(sb);
        pw.close();

    }

    public static void add(int x, int y){
        if (hasCow[x][y]) return;
        ans++;
        hasCow[x][y] = true;
        if (adj[x][y] == 3) {
            for (int[] a : new int[][]{{x - 1, y}, {x + 1, y}, {x, y - 1}, {x, y + 1}}) {
                add(a[0], a[1]);
            }
        }
        for (int[] a : new int[][]{{x - 1, y}, {x + 1, y}, {x, y - 1}, {x, y + 1}}) {
            int u = a[0];
            int v = a[1];
            adj[u][v]++;
            if (adj[u][v] == 3 && hasCow[u][v])
                for (int[] b: new int[][]{{u - 1, v}, {u + 1, v}, {u, v - 1}, {u, v + 1}}) {
                    add(b[0], b[1]);
                }
        }
    }

}
