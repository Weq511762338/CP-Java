//package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class yearofthecow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Integer> time = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            time.add(Integer.parseInt(br.readLine())/12*12);
        }
        br.close();
        long ans = 0;
        ans += time.size()* 12L;
        k--;
        PriorityQueue<Integer> dis = new PriorityQueue<>((a, b) -> b-a);
        Collections.sort(time);
        for(int i = 0; i < time.size()-1; i++){
            dis.add(time.get(i+1) - time.get(i) - 12);
        }
        dis.add(time.get(0));
        while(k != 0){
            k--;
            dis.poll();
        }
        for(int i  : dis) ans += i;
        pw.println(ans);
        pw.close();
    }
}
