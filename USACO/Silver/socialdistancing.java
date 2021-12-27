//package Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class socialdistancing {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);

        BufferedReader br = new BufferedReader(new FileReader("socdist.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("socdist.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n  = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Long> grass = new ArrayList<>();
        long max = 0;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            long a  = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            max = Math.max(Math.max(a , b), max);
            grass.add(a);
            grass.add(b);
        }
        Collections.sort(grass);
        br.close();
        long l = 0;
        long r = max;

        while(l < r){
            long mid = (l+r+1)/2;

            if (valid(grass, n, mid)){
                l = mid;
            } else
                r = mid-1;
        }

        pw.println(l);
        pw.close();
    }

    public static boolean valid(ArrayList<Long> grass, int n, long d){
        int index = 0;
        long cow = 1;
        long lastpos = grass.get(0);

        while(index < grass.size()){
            long left = grass.get(index++);
            long right = grass.get(index++);

            left = Math.max(lastpos+d, left);
            if (right < left) continue;
            long count = (right - left)/d;
            cow += count+1;
            lastpos = left + count*d;
        }
        return cow >= n;
    }
}
