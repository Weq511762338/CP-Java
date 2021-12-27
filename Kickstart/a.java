package Kickstart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == '1') list.add(j);
            }

            list = new ArrayList<>();
            n = 5*100000;
            list.add(0);
            list.add(n-1);

            long ans = 0;
            ans += (long) (list.get(0)) *(list.get(0)+1)/2;
            for(int j = 0; j < list.size()-1; j++){
                int cur = list.get(j);
                int next = list.get(j+1);
                int numbt = next - cur -1;
                ans += (long) (numbt / 2) *(numbt/2+1);
                if (numbt%2 == 1) ans += numbt/2+1;
            }
            ans += (long) (n - list.get(list.size() - 1) - 1 + 1) *(n-list.get(list.size()-1)-1)/2;
            sb.append("Case #").append(i + 1).append(": ").append(ans).append("\n");
        }
        br.close();
        pw.print(sb);
        pw.close();
    }
}
