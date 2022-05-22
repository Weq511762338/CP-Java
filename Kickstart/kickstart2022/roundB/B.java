package kickstart2022.roundB;

import javax.management.StringValueExp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for(int i = 1; i <= t; i++){
            long a = Long.parseLong(br.readLine());
            long ans = 0;
            int f11 = 0;
            while (a % 11 == 0){
                f11++;
                a /= 11;
            }
            if (f11 == 0){
                if (a >= 10) {
                    String s = String.valueOf(a);
                    boolean work = true;
                    for (int x = 0; x < s.length() / 2; x++) {
                        if (s.charAt(x) != s.charAt(s.length() - x - 1)) {
                            work = false;
                            break;
                        }
                    }
                    if (work) ans++;
                }
                for(int num = 1; num <= 9; num++){
                    if (a % num == 0) ans++;
                }
            }else {
                int count = primeFactors(a);
                if (count != 0) {
                    ans = (1L << (count)) + 1;
                    ans *= f11;
                } else{
                    ans = f11+1;
                }

            }
            pw.println("Case #" + i + ": " + ans);
        }
        br.close();
        pw.close();
    }

    public static int primeFactors(long n) {
        int count = 0;
        while (n % 2 == 0) {
            count++;
            n /= 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                count++;
                n /= i;
            }
        }
        if (n > 2) count++;
        return count;
    }

}