package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PizzaForces {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] ans = new long[t];
        for (int i = 0; i < t; i++) {
            long n = Long.parseLong(br.readLine());


            if (n%2 == 1)
                n++;
            long c10 = n/10;
            long c6 = 0;
            long c8 = 0;


            long carry = n%10;

            if (carry == 0)
                ;
            else if (carry %6 == 0)
                c6 ++;
            else if (carry%8 == 0)
                c8++;
            else if (c10 > 0){
                if (carry == 2)
                    c6 += 2;
                if (carry == 4) {
                    c8++;
                    c6++;
                }
                c10--;
            } else if (c10 == 0)
                c6++;

            ans[i] = c10*25+c8*20+c6*15;
        }

        for (int i = 0; i < t; i++) {
            System.out.println(ans[i]);
        }
    }
}
