//package Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swap {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);

        BufferedReader br = new BufferedReader(new FileReader("swap.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int n  = Integer.parseInt(st.nextToken());
        int m  = Integer.parseInt(st.nextToken());
        int k  = Integer.parseInt(st.nextToken());
        int[] p = new int[n+1];
        for(int i  = 1; i <= n; i++) p[i] = i;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for (int j = a; j <= (a+b)/2 ; j++) {
                int t = p[j];
                p[j] = p[b-(j-a)];
                p[b-(j-a)] = t;
            }
        }
        br.close();
        int[] ans = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if (ans[i] == 0) {
                ArrayList<Integer> cycle = new ArrayList<>();
                cycle.add(i);
                int cur = p[i];
                while (cur != i) {
                    cycle.add(cur);
                    cur = p[cur];
                }
                int mod = k % cycle.size();
                for (int j = 0; j < cycle.size(); j++) {
                    ans[cycle.get(j)] = cycle.get((j + mod) % cycle.size());
                }
            }
        }


        for(int i = 1; i <= n; i++)
            pw.println(ans[i]);
        pw.close();
    }
}
