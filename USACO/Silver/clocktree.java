//package Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class clocktree {
    public static ArrayList<Integer>[] adj;
    public static int[] time;
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("clocktree.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("clocktree.out")));

        int n = Integer.parseInt(br.readLine());
        time = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++){
            time[i] = Integer.parseInt(st.nextToken());
        }
        adj = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for(int i = 0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        br.close();
        int ans = 0;

        for(int i = 1; i <= n; i++) {
            time[i]--;
            int res = dfs(i, 0);
            if (res ==12 || res == 1) ans++;
            time[i]++;
        }

        pw.println(ans);
        pw.close();

    }

    public static int dfs(int x, int y){
        int sum = time[x] + 1;
        for(int i : adj[x]){
            if (i != y) {
                sum += 12-dfs(i, x) + 1;
            }
        }
        return sum%12 == 0 ? 12 : sum%12;
    }
}
