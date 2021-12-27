//package Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class milkvisits {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("milkvisits.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String col = br.readLine();
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for(int i = 1;  i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
           adj[a].add(b);
           adj[b].add(a);
        }

        int[] group = new int[n+1];
        int num = 1;
        for(int i = 1; i <= n ; i++ ) if (group[i] == 0){
            dfs(col, adj, group, i, num);
            num++;
        }
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            char type = st.nextToken().charAt(0);

            if(col.charAt(a-1) == type || group[a] != group[b]) sb.append(1);
            else sb.append(0);
        }
        br.close();
        pw.println(sb);
        pw.close();
    }
    public static void dfs(String col, ArrayList<Integer>[] adj, int[] group, int x, int num){
        if (group[x] == num) return;
        group[x] = num;
        for(int i : adj[x]) if (col.charAt(i-1) == col.charAt(x-1)) dfs(col, adj, group, i, num);
    }
}
