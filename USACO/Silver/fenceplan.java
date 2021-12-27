//package Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class fenceplan {
    static boolean[] visited;
    static int maxX;
    static int minX;
    static int minY;
    static int maxY;
    static ArrayList<Integer>[] adj;
    static Cow[] cow;
    static class Cow{
        int x;
        int y;

        public Cow(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("fenceplan.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n+1];
        for(int i = 1; i <= n ; i++) adj[i] = new ArrayList<>();
        cow = new Cow[n+1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y =Integer.parseInt(st.nextToken());
            cow[i+1] = new Cow(x, y);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        br.close();
        visited = new boolean[n+1];
        long ans = Long.MAX_VALUE;

        for(int i = 1; i <= n; i++){
            minX = Integer.MAX_VALUE;
            maxX = 0;
            maxY = 0;
            minY = Integer.MAX_VALUE;
            if (!visited[i]){
                dfs(i);
                ans = Math.min(ans,  (maxX - minX + maxY - minY)* 2L);
            }
        }
        pw.println(ans);
        pw.close();
    }
    public static void dfs(int i){
        visited[i] = true;
        maxX = Math.max(maxX, cow[i].x);
        minX = Math.min(minX, cow[i].x);
        maxY = Math.max(maxY, cow[i].y);
        minY = Math.min(minY, cow[i].y);
        for(int a : adj[i]){
            if (!visited[a])
                dfs(a);
        }
    }
}
