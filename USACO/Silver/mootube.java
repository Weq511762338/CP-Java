//package Silver;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class mootube {
    static ArrayList<Edge>[] adj;
    static int count;
    static class Edge{
        int end;
        int r;

        public Edge(int end, int r) {
            this.end = end;
            this.r = r;
        }
    }
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n+1];
        for(int i = 1; i <= n ;i++) adj[i] = new ArrayList<>();
        for(int i = 0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            adj[a].add(new Edge(b, r));
            adj[b].add(new Edge(a, r));
        }

        for(int i = 0 ; i <q; i++){
            count = 0;
            st = new StringTokenizer(br.readLine());
            int k =Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            bfs(v, k, 0, Integer.MAX_VALUE);
            pw.println(count);
        }
        br.close();
        pw.close();
    }

    public static void bfs(int i, int k, int j, int min){

        for(Edge e : adj[i]){
            if (e.end != j && Math.min(min, e.r) >= k) {
                bfs(e.end, k, i, Math.min(min, e.r));
                count++;
            }
        }
    }
}
