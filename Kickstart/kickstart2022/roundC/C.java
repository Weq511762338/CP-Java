package Kickstart.kickstart2022.roundC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class C {

    public static class Pair{
        int index;
        int pos;

        int dir;

        public Pair(int index, int pos, int dir) {
            this.index = index;
            this.pos = pos;
            this.dir = dir;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            Pair[] arr = new Pair[n];
            int count = 0;
            for(int j = 1; j <= n; j++){
                st = new StringTokenizer(br.readLine());
                int pos = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                arr[j-1] = new Pair(j, pos, d);
                if (d == 1) count++;
            }
            Arrays.sort(arr, (a, b) -> a.pos - b.pos);
            ArrayList<Pair> list = new ArrayList<>();

            int left = 1;
            int right = n-count+1;
            for(int j = 1; j <= n; j++){
                Pair p = arr[j-1];
                if (p.dir == 0){
                    list.add(new Pair(arr[left++-1].index, p.pos, p.dir));
                }else{
                    list.add(new Pair(arr[right++-1].index, l-p.pos, p.dir));
                }
            }
            Collections.sort(list, (a, b) -> a.pos == b.pos ? a.index - b.index : a.pos - b.pos);
            pw.print("Case #" + i + ": ");
            for(int j = 0; j < list.size()-1; j++)
                pw.print(list.get(j).index + " ");
            pw.println(list.get(list.size()-1).index);
        }
        br.close();
        pw.close();


    }

}
