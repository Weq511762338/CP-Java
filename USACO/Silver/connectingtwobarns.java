//package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class connectingtwobarns {

    static HashSet<Integer> visited;
    static int n;
    static ArrayList<Integer>[] adj;
    static ArrayList<TreeSet<Integer>> component;
    static TreeSet<Integer> start;
    static TreeSet<Integer> end;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test = 0; test < t ;test++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            visited = new HashSet<>();
            adj = new ArrayList[n+1];
            for(int i = 1; i <=n ;i++){
                adj[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a].add(b);
                adj[b].add(a);
            }
            component = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (visited.contains(i)) continue;
                bfs(i);
            }
            ans = Long.MAX_VALUE;
            if (start == end) ans = 0;
            else{
                ans = Math.min(ans, compare(start, end));
                for(TreeSet<Integer> comp : component){
                    if (comp == start || comp == end) continue;
                    ans = Math.min(ans, compare(comp));
                }
            }
            sb.append(ans + System.lineSeparator());
        }
        br.close();
        pw.print(sb);
        pw.close();
    }

    public static long compare(TreeSet<Integer> mid){
        return compare(start, mid) + compare(mid, end);
    }

    public static long compare(TreeSet<Integer> comp1, TreeSet<Integer> comp2){
        long min = Long.MAX_VALUE;
        if (comp1.size() > comp2.size()){
            var t = comp1;
            comp1 = comp2;
            comp2 = t;
        }
        for(int i : comp1){
            int left = comp2.lower(i) == null ? -1 : comp2.lower(i);
            int right = comp2.higher(i) == null ? -1 : comp2.higher(i);
            if (left == -1)
                min = Math.min(min, (long) (i - right) *(i-right));
            else if (right == -1)
                min = Math.min(min, (long) (i - left) *(i-left));
            else
                min = Math.min(min, Math.min((long) (i - left) *(i-left), (long) (i - right) *(i-right)));
        }

        return min;
    }

    public static void bfs(int id){

        TreeSet<Integer> contain = new TreeSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()) {
            int node = q.poll();
            contain.add(node);
            for (int i : adj[node]) {
                if (!contain.contains(i))
                    q.add(i);
            }
        }
        component.add(contain);
        visited.addAll(contain);
        if (contain.contains(1)) start = contain;
        if (contain.contains(n)) end = contain;
    }


}
