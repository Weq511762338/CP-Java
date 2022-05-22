package Kickstart.kickstart2022.roundC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class D {

    static long count;
    static int N;
    static int MOD = (int) 1e9+7;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for(int i = 1; i <= t ; i++){
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            // n! is the denominator
            count = 0;
            N = n;
            help(new String(str));
            int total = 1;
            for(int j = 1; j <= n; j++){
                total *= j;
            }
            long ans = binpow(total, MOD-2)*count%MOD;

            pw.println("Case #" + i + ": " + ans);
        }
        br.close();
        pw.close();

    }


    public static void help(String str){
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        if (str.length() == 0) {
            count++;
            return;
        }
        for(int i = 0; i < str.length(); i++){
            if (str.length() != N && str.equals(sb.toString())) {
                count ++;
            }
            help(str.substring(0, i) + str.substring(i+1));
        }
    }

    public static long binexp(long cur, int num, int pow){
        if(pow == 0) return cur;
        if(pow%2 == 1) cur = cur*num%MOD;
        return binexp(cur*cur%MOD, num, pow/2);
    }

    static long binpow( long a,  long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                res = res * a % MOD;
            a = a * a %MOD;
            b >>= 1;
        }
        return res;
    }
}
