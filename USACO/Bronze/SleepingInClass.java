package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SleepingInClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader( new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb  = new StringBuilder();
        for (int i = 0; i < t; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            sb.append(sol(list, n) + "\n");
        }
        br.close();
        pw.print(sb);
        pw.close();
    }
    public static class Pair{
        int op, avg;

        public Pair(int op, int avg) {
            this.op = op;
            this.avg = avg;
        }
    }
    public static int sol(ArrayList<Integer> list , int n){
        int max = 0;
        int sum = 0;
        for(int i : list) {
            max = Math.max(i, max);
            sum += i;
        }
        ArrayList<Pair> pair = new ArrayList<>();
        if (sum%n == 0 && sum/n == max) return 0;
        for(int i = 1; i <= n-1; i++){
            if (sum % (n-i) == 0 && sum/(n-i) >= max)
                pair.add(new Pair(i, sum/(n-i)));
        }

        int ans = n;
        loop : for(Pair p : pair){
            int op = p.op;
            int avg = p.avg;
            int num = 0;
            int count = 0;
            for(int i = 0 ; i < n; i++){
                num += list.get(i);
                if (num > avg) continue loop;
                if (num == avg) num = 0;
                else count++;
            }
            if (num > avg) continue;
            if (count == op) ans = Math.min(ans, count);
        }
        return ans;
    }
}
