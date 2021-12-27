//package Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class grassplanting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("planting.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        br.close();

        int max = 0;
        for(int i = 1; i <= n; i++){
            max = Math.max(max, adj[i].size()+1);
        }
        pw.println(max);
        pw.close();
    }
}
