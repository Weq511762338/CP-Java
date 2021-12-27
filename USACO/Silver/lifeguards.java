//package Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class lifeguards {
    static class Seg{
        int start;
        int end;
        public Seg(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));

        int n= Integer.parseInt(br.readLine());
        ArrayList<Seg> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Seg(start, end));
        }
        br.close();

        Collections.sort(list, Comparator.comparingInt(a -> a.start));
        int ans = 0;
        int min = Integer.MAX_VALUE;
        int rem = 0;
        int i1 = 0;
        int i2 = 1;
        for (; i1 < n-1 && i2 < n; i1++) {
            Seg s1 = list.get(i1);
            Seg s2 = list.get(i2);
            if (s2.start > s1.end){
                min = Math.min(s1.end - s1.start - rem, min);
                rem = 0;
                ans += s1.end - s1.start;
                i1 = i2-1;
            }else if (s2.end < s1.end){
                min = 0;
                rem = 0;
                i1--;
            }else {
                min = Math.min(s2.start - s1.start - rem, min);
                rem = s1.end - s2.start;
                ans += s1.end - s1.start;
                ans -= rem;
                i1 = i2-1;
            }
            i2++;
        }
        Seg s1 = list.get(i1);
        ans += s1.end - s1.start;
        min = Math.min(min, s1.end - s1.start - rem);

        pw.println((ans - min));
        pw.close();
    }
}
