//package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.TreeSet;

public class p1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int g = 0;
            int h = 0;

            for (int j = i; j < n; j++) {
                if (str.charAt(j) == 'G') g++;
                else h++;
                if (g + h >= 3 && (g==1 || h==1)) ans ++;
            }
        }
        pw.println(ans);
        pw.close();

    }
}
