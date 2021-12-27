package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class BalancedSubstring {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            int[] pa = new int[n+1];
            int[] pb = new int[n+1];
            for (int j = 0; j < n; j++) {
                pa[j+1] = pa[j] + (s.charAt(j) == 'a' ? 1 : 0);
                pb[j+1] = pb[j] + (s.charAt(j) == 'b' ? 1 : 0);
            }

            boolean found = false;
            loop : for (int j = 1; j <= n; j++) {
                for (int k = j+1; k <= n; k++) {
                    if (pa[k] - pa[j-1] == pb[k] - pb[j-1]) {
                        sb.append(j + " " + k + '\n');
                        found = true;
                        break loop;
                    }
                }
            }
            if (!found) sb.append("-1 -1" + '\n');

        }
        br.close();
        pw.print(sb);
        pw.close();
    }
}
