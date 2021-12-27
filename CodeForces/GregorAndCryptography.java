package CodeForces;

import java.awt.image.ImagingOpException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GregorAndCryptography {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());
            ans.append(2 + " " + (num-1) + "\n");
        }
        br.close();
        System.out.println(ans);
    }
}
