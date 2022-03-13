package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n  = Integer.parseInt(br.readLine());
        ArrayList<Integer> expected = new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;  i < n; i++){
            expected.add(Integer.parseInt(st.nextToken()));
        }
         st = new StringTokenizer(br.readLine());
        for(int i = 0;  i < n; i++){
            cur.add(Integer.parseInt(st.nextToken()));
        }
        br.close();

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = expected.get(i);
            int b = cur.get(i);

            if (a - b > 0) {
                pos.add(a - b);
                neg.add(0);
            }
            else if (a - b < 0){
                neg.add(Math.abs(a - b));
                pos.add(0);
            }
            else {
                neg.add(0);
                pos.add(0);
            }
    }
        int ans = 0;
        ans += pos.get(0);

        for (int i = 0; i < n-1; i++) {
            int t1 = pos.get(i);
            int t2 = pos.get(i+1);

            if (t2 > t1) ans += t2 - t1;
        }
        ans += neg.get(0);
        for (int i = 0; i < n-1; i++) {
            int t1 = neg.get(i);
            int t2 = neg.get(i+1);

            if (t2 > t1) ans += t2 - t1;
        }
        pw.println(ans);
        pw.close();

    }
}
