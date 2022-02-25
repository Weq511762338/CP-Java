//package Silver;

import java.io.*;
import java.util.*;

public class diamond {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("diamond.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("diamond.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        br.close();
        Collections.sort(list);

        int[] atMost = new int[n];
        int[] atLeast = new int[n];
        Deque<Integer> deque = new LinkedList<>();
        atMost[0] = 1;
        deque.add(list.get(0));
        for(int i= 1; i < n; i++){
            deque.add(list.get(i));
            while(deque.peekFirst() < list.get(i)-k)
                deque.pollFirst();
            atMost[i] = Math.max(atMost[i-1], deque.size());
        }
        deque.clear();
        atLeast[n-1] = 1;
        deque.offerFirst(list.get(n-1));
        for(int i= n-2; i >= 0; i--){
            deque.offerFirst(list.get(i));
            while(deque.peekLast() > list.get(i)+k)
                deque.pollLast();
            atLeast[i] = Math.max(atLeast[i+1], deque.size());
        }

        int ans = 0;
        for(int i= 0; i < n-1; i++){
            ans = Math.max(atMost[i] + atLeast[i+1], ans);
        }
        pw.println(ans);
        pw.close();
    }
}
