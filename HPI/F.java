import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class F {
    static class Edge{
        int to, w;

        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }
    static ArrayList<Edge>[] adj;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n+1];
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[a].add(new Edge(b, w));
            adj[b].add(new Edge(a, w));
        }
        br.close();
        dfs(1, 1);

    }

    public static void dfs(int src, int cur){
        ans++;
        for(int i = 0; i < adj[cur].size(); i++){
            Edge e1 = adj[cur].get(i);
            if (e1.to == src) continue;

        }

    }
}
