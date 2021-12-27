//package Silver;

import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class WhyDidheCowCrossTheRoad {

    public static class Cow{
        int start;
        int end;
        public Cow(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("helpcross.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] chick = new int[c];
        Cow[] cow = new Cow[n];
        for (int i = 0; i < c; i++) {
            chick[i] = (Integer.parseInt(br.readLine()));
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cow[i] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        br.close();
        Arrays.sort(chick);
        int ans = 0;
        for (int i = 0; i < c; i++) {
            int closest = -1;
            for (int j = 0; j < n; j++) {
                if (cow[j] != null && cow[j].start <= chick[i] && cow[j].end >= chick[i])
                    if (closest == -1 || cow[j].end < cow[closest].end)
                        closest = j;
            }
            if (closest != -1){
                ans ++;
                cow[closest] = null;
            }
        }

        pw.println(ans);
        pw.close();
    }
}
