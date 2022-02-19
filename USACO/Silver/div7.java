//package Silver;

import java.io.*;
import java.util.Arrays;

public class div7 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("div7.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
        int n = Integer.parseInt(br.readLine());
        int[] first = new int[7];
        int[] last = new int[7];
        Arrays.fill(first, Integer.MAX_VALUE);
        int sum = 0;
        for(int i= 1; i <= n; i++){
            int num  = Integer.parseInt(br.readLine());
            sum = (sum + num) % 7;
            first[sum] = Math.min(first[sum], i);
            last[sum] = i;
        }
        br.close();

        int ans = 0;
        for(int i = 0; i < 7; i++){
            ans = Math.max(ans, last[i] - first[i]);
        }

        pw.println(ans);
        pw.close();

    }
}
