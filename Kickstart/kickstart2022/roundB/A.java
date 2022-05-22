package kickstart2022.roundB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long r = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long sum = r*r;
            long count = 0;
            while(r != 0) {
                if (count == 0)
                    r *= a;
                else
                    r /= b;
                sum += r*r;
                count ++;
                count %= 2;
            }
            double ans = Math.PI*sum;
            sb.append("Case #" + i + ": " + ans + "\n");
        }
        br.close();
        pw.print(sb);
        pw.close();

    }
}
