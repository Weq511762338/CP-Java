package Kickstart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.function.IntUnaryOperator;

public class BananaBunches {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i =1; i <= t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n  =Integer.parseInt(st.nextToken());
            int k  = Integer.parseInt(st.nextToken());
            int[] prefix = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n;j++){
                prefix[j] = prefix[j-1] + Integer.parseInt(st.nextToken());
            }
            int ans = Integer.MAX_VALUE;
            for(int p1 = 0; p1 < n; p1++) {
                for (int p2 = p1 + 1; p2 <= n; p2++) {
                    if (p2-p1 >= ans) continue;
                    long sum = prefix[p2]-prefix[p1];
                    if (sum > k)
                        break;
                    if (sum == k)
                        ans = Math.min(p2-p1,ans);
                    else{
                        for(int p3 = p2+1; p3 < n;p3++){
                            for(int p4 = p3+1; p4 <=n; p4++){
                                if (p4-p3 >= ans) continue;
                                if (sum + prefix[p4]-prefix[p3] == k){
                                    ans = Math.min(p2-p1+p4-p3,ans);
                                }else if (sum + prefix[p4]-prefix[p3] > k)
                                    break;
                            }
                        }
                    }
                }
            }
            sb.append("Case #" + i + ": " + (ans == Integer.MAX_VALUE ? -1 : ans) + "\n");
        }
        br.close();
        pw.print(sb);
        pw.close();
    }
}
