//package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SearchingForSoulmates {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long ans = 0;
            while (a*2 < b){
                if (b % 2 == 1) {
                    b--;
                    ans++;
                }
                b /=2 ;
                ans++;
            }
            while (a > b){
                if (a % 2 == 1) {
                    a++;
                    ans++;
                }
                a /=2 ;
                ans++;
            }
            sb.append((ans + compute(a, b)) + System.lineSeparator());
        }
        br.close();
        pw.print(sb);
        pw.close();
    }

    public static long compute(long a, long b){
        if (a == b) return 0;
        return Math.min(b - a, compute((a + a%2)/2, (b-b%2)/2) + a%2 + b%2 + 2);
    }
}
