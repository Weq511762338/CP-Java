//package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

class cereal2 {
    public static class Cow{
        int id;
        int from;
        int to;
        int first;
        int second;

        public Cow(int id, int from, int to, int first, int second) {
            this.from = from;
            this.to = to;
            this.id = id;
            this.first = first;
            this.second = second;
        }
    }
    static int n;
    static int m;
    static ArrayList<Integer> list;
    static ArrayList<Cow>[] adj;
    static int[] visited;
    static Cow extra = null;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adj = new ArrayList[m+1];
        for(int i = 1; i <= m; i++) adj[i] = new ArrayList<>();
        for(int i = 1 ; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(new Cow(i, a, b, a, b));
            adj[b].add(new Cow(i, b, a, a, b));
        }
        br.close();

        list = new ArrayList<>();
        visited = new int[m+1];
        Arrays.fill(visited, 0);
        for (int i = 1; i <= m; i++) {
            if (visited[i] == 0) {
                dfs1(i, null);
                if (extra == null) {
                    visited[i] = 2;
                    dfs2(i);
                } else {
                    visited[extra.first] = 2;
                    list.add(extra.id);
                    dfs2(extra.first);
                }
            }
            extra = null;
        }
        pw.println(n-list.size());
        for(int i : list) pw.println(i);
        HashSet<Integer> set = new HashSet<>(list);
        for(int i = 1 ;i <= n ; i++) {
            if (!set.contains(i)) pw.println(i);
        }
        pw.close();
    }

    public static void dfs1(int node, Cow cow){
        if (visited[node] != 0){
            if (extra == null) extra = cow;
            return;
        }
        visited[node] = 1;
        for(Cow c : adj[node]){
            if (cow == null || cow.id != c.id)
                dfs1(c.to, c);
        }
    }

    public static void dfs2(int node){
        visited[node] = 2;
        for(Cow c : adj[node]){
            if (visited[c.to] == 1 && (extra == null || c.id != extra.id)){
                list.add(c.id);
                visited[c.to] = 2;
                dfs2(c.to);
            }
        }
    }
}