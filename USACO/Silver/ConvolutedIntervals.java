//package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class ConvolutedIntervals {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> start = new HashMap<>();
        HashMap<Integer, Integer> end = new HashMap<>();
        long[] ans = new long[2*m+1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (!start.containsKey(a)) start.put(a, 1);
            else start.put(a, start.get(a) + 1);
            if (!end.containsKey(b)) end.put(b, 1);
            else end.put(b, end.get(b) + 1);
        }
        br.close();

        for(Map.Entry<Integer, Integer> e1 : start.entrySet())
            for(Map.Entry<Integer, Integer> e2 : start.entrySet())
                ans[e1.getKey()+e2.getKey()] += (long) e1.getValue() *e2.getValue();

        for(Map.Entry<Integer, Integer> e1 : end.entrySet())
            for(Map.Entry<Integer, Integer> e2 : end.entrySet())
                if (e1.getKey()+e2.getKey()+1 <= 2*m)
                    ans[e1.getKey()+e2.getKey()+1] -= (long) e2.getValue() *e1.getValue();

        long carry = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ans.length; i++){
            carry += ans[i];
            sb.append(carry + "\n");
        }
        pw.print(sb);
        pw.close();
    }
}
