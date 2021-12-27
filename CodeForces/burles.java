package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class burles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        int[] q = new int[n];
        for (int i = 0; i < n; i++) {
            int amount = Integer.parseInt(br.readLine());
            q[i] = amount;
        }
        br.close();
        for (int i = 0; i < n; i++) {
            int ans1 = q[i]/3;
            int ans2 = q[i]/3;
            int mod = q[i]%3;
            if (mod == 1)
                ans1++;
            if (mod == 2)
                ans2++;
            System.out.println(ans1 + " " + ans2);
        }
    }
}
