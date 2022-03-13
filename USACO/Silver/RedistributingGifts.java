package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class RedistributingGifts {
    static int n;
    static boolean[][] reachable;
    static ArrayList<Integer>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        n = Integer.parseInt(br.readLine());
        adj = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            adj[i] = new ArrayList();
        }
        reachable = new boolean[n+1][n+1];
        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                adj[i].add(a);
                if (a == i) break;
            }
        }
        br.close();
        for(int i = 1; i <= n; i++){
            dfs(i, i);
        }
        for(int i = 1; i <= n; i++){
            for(int j : adj[i])
                if (reachable[j][i]){
                    pw.println(j);
                    break;
                }
        }
        pw.close();
    }

    public static void dfs(int i, int j){
        if (reachable[i][j]) return;
        reachable[i][j] = true;
        for(int a : adj[j])
            dfs(i, a);
    }
}
