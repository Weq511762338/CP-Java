//package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class loan {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("loan.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        br.close();

        long l = 1;
        long r = n/m;

        while(l < r){
            long mid = (l+r+1)/2;
            if (afterK(mid, n, m, k)){
                l = mid;
            } else{
                r = mid-1;
            }
        }
        pw.println(l);
        pw.close();
    }

    public static boolean afterK(long x, long n, long m, long k){
        long cur = 0;

        for (long i = 1; i <= k; i++) {
            long y = (n-cur)/x;
            if (y < m){
                cur += (k-i+1)*m;
                break;
            }

            long days = (n-cur)%x/y+1;
            i += days-1;
            cur += days*y;
        }
        return cur >= n;
    }
}
