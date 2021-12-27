package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.Buffer;

public class ChessTournament {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            int[] player = new int[n];
            int t1 = 0;
            int t2 = 0;
            for(int j = 0 ; j < n; j++) {
                player[j] = s.charAt(j) == '1' ? 1 : 2;
                if (s.charAt(j) == '1') t1 ++;
                else t2++;
            }

            if (t2 >= 3 || t2 == 0){
                String[][] m = new String[n][n];
                boolean[] win = new boolean[n];
                sb.append("YES" + '\n');
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (j == k) m[j][k] = "X";
                        else if (m[j][k] == null){
                            if (player[j] == 1 || player[k] == 1){
                                m[j][k] = "=";
                                m[k][j] = "=";
                            }else{
                                if (!win[j]) {
                                    m[j][k] = "+";
                                    m[k][j] = "-";
                                    win[j] = true;
                                } else{
                                    m[j][k] = "-";
                                    m[k][j] = "+";
                                    win[k] = true;
                                }
                            }
                        }
                    }
                }

                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        sb.append(m[j][k]);
                    }
                    sb.append(System.lineSeparator());
                }
            } else{
                sb.append("NO" + '\n');
            }

        }
        br.close();
        pw.print(sb);
        pw.close();
    }
}
