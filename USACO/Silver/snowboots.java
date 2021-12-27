//package Silver;

import java.io.*;
import java.util.*;

public class snowboots {
    static boolean[][] visited;
    static int[] tile;
    static Shoes[] boot;
    static int ans = Integer.MAX_VALUE;
    public static class Shoes{
        int depth;
        int dis;

        public Shoes(int depth, int dis) {
            this.depth = depth;
            this.dis = dis;
        }
    }
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("snowboots.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        tile = new int[n];
        boot = new Shoes[b];
        for (int i = 0; i < n; i++) {
            tile[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < b; i++){
            st = new StringTokenizer(br.readLine());
            int dep = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            boot[i] = new Shoes(dep, dis);
        }
        br.close();
        visited = new boolean[n][b];
        rec(0, 0);
        pw.println(ans);
        pw.close();
    }

    public static void rec(int n, int b){
        if (visited[n][b]) return;
        if (tile[n] > boot[b].depth) return;
        visited[n][b] = true;
        if (n == tile.length-1){
            ans = Math.min(ans, b);
            return;
        }

        for(int i = n; i <= Math.min(n+boot[b].dis, tile.length-1); i++){
            rec(i, b);
        }
        for(int i = b; i < boot.length; i++){
            rec(n, i);
        }
    }
}
