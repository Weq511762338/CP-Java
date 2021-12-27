package Kickstart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class b {

    static class Event{
        int s;
        int e;
        int h;

        public Event(int s, int e, int h) {
            this.s = s;
            this.e = e;
            this.h = h;
        }
    }
    static class EP {
        Event e;
        int time;

        public EP(Event e, int time) {
            this.e = e;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i  = 1; i <= t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d =Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            PriorityQueue<EP> start = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
            PriorityQueue<EP> end = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
            for(int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                int h = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                Event event = new Event(s, e, h);
                start.add(new EP(event, s));
                end.add(new EP(event, e));
            }

            PriorityQueue<Event> inK = new PriorityQueue<>(Comparator.comparingInt(a -> a.h));
            PriorityQueue<Event> active = new PriorityQueue<>(Comparator.comparingInt(a -> -a.h));
            HashSet<Event> inKc = new HashSet<>();
            HashSet<Event> activec = new HashSet<>();
            long cur = 0;
            long ans = 0;
            while(!end.isEmpty()){
                Event event;
                if (start.isEmpty()) event = end.poll().e;
                else if (start.peek().time <= end.peek().time) event = start.poll().e;
                else event = end.poll().e;
                if (!inKc.contains(event) && ! activec.contains(event)){//new interval to be added
                    if (inK.size() < k){// add to the first Kth
                        inK.add(event);
                        inKc.add(event);
                        cur += event.h;
                    }else if(inK.peek().h < event.h){
                        Event a = inK.poll();
                        inKc.remove(a);
                        cur -= a.h;
                        active.add(a);
                        activec.add(a);
                        inK.add(event);
                        inKc.add(event);
                        cur += event.h;
                    }else {
                        active.add(event);
                        activec.add(event);
                    }
                } else if(inKc.contains(event)){
                    inK.remove(event);
                    inKc.remove(event);
                    cur -= event.h;
                    Event a = active.poll();
                    if (a != null) {
                        active.remove(a);
                        cur += a.h;
                        inK.add(a);
                        inKc.add(a);
                    }
                } else {
                    active.remove(event);
                    activec.remove(event);
                }
                ans = Math.max(ans, cur);
            }

            sb.append("Case #").append(i).append(": ").append(ans).append("\n");
        }
        br.close();
        pw.print(sb);
        pw.close();
    }
}
