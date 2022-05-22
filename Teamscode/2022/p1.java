import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class p1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long ans = 0;
        long count =0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ans += solve(a, b, k);
            b *= k;
            if(a < b) {
                count += (b - a) / k;
                long num = (b - a) % k;
                if(num < k - num + 1) {
                    count += num;
                }else {
                    count += k - num + 1;
                }
            }else {
                count += (a - b) / k;
                long num = (a - b) % k;
                if(num < k - num + 1) {
                    count += num;
                }else {
                    count += k - num + 1;
                }
            }
        }
        br.close();
        pw.println(ans + " " + count);
        pw.close();
    }
    public static long solve(long a, long b, long k) {
        long low = a / k;
        long high = a / k +1;
        long lowans = b-low+a-(low*k);
        long highans = b-high+(high*k)-a;
        long res = b + a;
        return Math.min(res,Math.min(lowans, highans));
    }
}
