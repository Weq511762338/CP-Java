package Kickstart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class StayingHydrated {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= t; i++){
            int k = Integer.parseInt(br.readLine());
            ArrayList<Integer> xs  = new ArrayList<>();
            ArrayList<Integer> ys  = new ArrayList<>();
            for(int j = 0 ; j < k ; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                xs.add(x1);
                xs.add(x2);
                ys.add(y1);
                ys.add(y2);
            }
            Collections.sort(xs);
            Collections.sort(ys);

            sb.append("Case #" + i + ": " + xs.get(xs.size()/2-1) + " " + ys.get(ys.size()/2-1) + "\n");
        }
        br.close();
        pw.print(sb);
        pw.close();
    }
}
