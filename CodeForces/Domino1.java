package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Domino1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][] q = new int[t][3];
        for (int i = 0; i < t; i++) {
            StringTokenizer st =new StringTokenizer(br.readLine());
            q[i][0] = Integer.parseInt(st.nextToken());
            q[i][1] = Integer.parseInt(st.nextToken());
            q[i][2] = Integer.parseInt(st.nextToken());
        }
        br.close();

        for (int i = 0; i <t; i++) {
            int n = q[i][0];
            int m = q[i][1];
            int k = q[i][2];

            if (m < 2)
                System.out.println("NO");
            else if (k == 0 && n%2 == 0)
                System.out.println("YES");
            else{
                if ((k/(m/2))%2 == 1 && k%(m/2) == 0)
                    System.out.println("YES");
                else if (k%2 == 0 && n%2 == 0)
                    System.out.println("YES");
                else
                    System.out.println("NO");

            }


        }
    }
}
