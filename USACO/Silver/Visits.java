//package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Visits {
    public static class Edge{
        int to;
        long cost;
        public Edge(int to, long cost){
            this.to = to;
            this.cost = cost;
        }
    }

    static Edge[] edge;
    static HashSet<Integer> cycles;
    static boolean[] visited;
    static int cycleStart;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        edge = new Edge[n+1];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edge[i+1] = new Edge(a, b);
        }
        br.close();
        visited = new boolean[n+1];

        long ans = 0;
        for(int i= 1; i <= n; i++){
            if (visited[i]) continue;
            cycles = new HashSet<>();
            cycleStart = -1;

            findCycle(i);
            if (cycleStart == -1) continue;

            long min = Integer.MAX_VALUE;
            int a = cycleStart;
            do {
                visited[a] = true;
                min = Math.min(min, edge[a].cost);
                ans += edge[a].cost;
                a = edge[a].to;
            }while(a != cycleStart);
            ans -= min;
        }

        for(int i = 1; i <= n; i++){
            if (!visited[i])
                ans += edge[i].cost;
        }
        pw.println(ans);
        pw.close();
    }

    public static void findCycle(int cur){
        if (visited[cur]) return;
        if (cycles.contains(cur)) {
            cycleStart = cur;
            return;
        }
        cycles.add(cur);
        findCycle(edge[cur].to);
    }
}
