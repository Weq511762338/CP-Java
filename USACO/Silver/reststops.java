//package Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class reststops {
    public static class Stop{
        int x;
        int c;

        public Stop(int x, int c) {
            this.x = x;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("reststops.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reststops.out")));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int rf = Integer.parseInt(st.nextToken());
        int rb = Integer.parseInt(st.nextToken());

        ArrayList<Stop> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Stop(x, c));
        }
        br.close();
        Collections.sort(list, (a, b)->b.c - a.c);

        long ans = 0;
        int lastx = 0;
        for(int i = 0; i < n; i++){
            Stop rest = list.get(i);
            if (rest.x < lastx) continue;
            ans += Math.max(0, rest.c*((long) (rest.x-lastx) *rf- (long) (rest.x-lastx) *rb));
            lastx = rest.x;
        }
        pw.println(ans);
        pw.close();
    }
}
