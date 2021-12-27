//package Silver;

import java.io.*;
import java.util.*;

public class conventiotnII {

    static class Cow{
        int arrive;
        int time;
        int priority;
        public Cow(int arrive, int time, int priority) {
            this.arrive = arrive;
            this.time = time;
            this.priority = priority;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("convention2.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("convention2.out")));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Cow> arriving = new PriorityQueue<>((a, b) -> a.arrive - b.arrive);
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Cow c = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
            arriving.add(c);
        }
        br.close();
        PriorityQueue<Cow> waiting = new PriorityQueue<>((a,b) -> a.priority - b.priority);
        long finish = 0;
        long start = 0;
        waiting.add(arriving.poll());
        long max = 0;
        Cow eating = null;
        eating  = waiting.poll();
        start = eating.arrive;
        finish = start + eating.time;
        while(true){
            max = Math.max(start - eating.arrive, max);
            while(!arriving.isEmpty() && arriving.peek().arrive <= finish) waiting.add(arriving.poll());
            if (arriving.isEmpty() && waiting.isEmpty()) break;
            if (waiting.isEmpty() && !arriving.isEmpty()) {
                waiting.add(arriving.poll());
                eating = waiting.poll();
                start = eating.arrive;
                finish = start + eating.time;
            } else {
                eating = waiting.poll();
                start = finish;
                finish = start + eating.time;
            }
        }

        pw.println(max);
        pw.close();
     }
}
