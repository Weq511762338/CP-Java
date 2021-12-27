//package Silver;

import java.io.*;
import java.util.*;

public class Cowntagion {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] farm = new int[n+1];
        int ans = n-1;
        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            farm[a]++;
            farm[b]++;
        }
        br.close();

        for (int i = 1; i < n+1; i++) {
            if (farm[i] > 1 || i == 1) { // check if is a root of a subtree
                int children = farm[i];
                if (i != 1)
                    children--;
                int duplicate = 1;
                while (duplicate < children+1) {
                    ans++;
                    duplicate *= 2;
                }
            }
        }
        System.out.println(ans);
    }

}
