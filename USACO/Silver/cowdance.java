//package Silver;

import java.io.*;
import java.util.*;

public class cowdance {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowdance.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("cowdance.out"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int maxT = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            list.add(a);
        }
        br.close();

        int left = 0;
        int right = n;
        while(left < right){
            int mid = (left + right)/2;
            if (sim(mid, list) <= maxT) right = mid;
            else left = mid+1;
        }
        pw.println(left);
        pw.close();
    }

    public static long sim (int k, ArrayList<Integer> list){
        long time = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int index = 0;
        for(; index < k; index++){
            pq.add((long) list.get(index));
        }
        while(!pq.isEmpty()){
            time = pq.peek();
            while(!pq.isEmpty() && pq.peek() == time) pq.poll();
            while(index < list.size() && pq.size() < k) pq.add(list.get(index++)+time);
        }
        return time;
    }
}
