//package Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class shuffle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine());
        int[] swap = new int[n+1];
        for (int i = 1; i <= n; i++) {
            swap[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        int ans = 0;

        ArrayList<Integer> cycle = new ArrayList<>();

        boolean[] visited = new boolean[n+1];
        HashSet<Integer> been = new HashSet<>();
        loop : for(int i = 1; i <= n; i++){
            if (!visited[i]){
                cycle.add(i);
                visited[i] = true;
                been.add(i);
                int ind = swap[i];
                while(!visited[ind]){
                    cycle.add(ind);
                    been.add(ind);
                    visited[ind] = true;
                    ind = swap[ind];
                }
                if (been.contains(ind)) {
                    for (int j = cycle.size() - 1; j >= 0; j--) {
                        ans++;
                        if (cycle.get(j) == ind) break;
                    }
                }
                been.clear();
                cycle.clear();
            }
        }
        pw.println(ans);
        pw.close();
    }
}
