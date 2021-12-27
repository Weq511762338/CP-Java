//package Silver;

import java.io.*;
import java.util.*;

public class Meetings {

    public static class Cow {
        int weight;
        int x;
        int d;
        int time;

        public Cow(int weight, int x, int d) {
            this.weight = weight;
            this.x = x;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("meetings.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("meetings.out")));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        ArrayList<Cow> xpos = new ArrayList<>();
        ArrayList<Cow> left = new ArrayList<>();
        ArrayList<Cow> right = new ArrayList<>();
        ArrayList<Cow> finish = new ArrayList<>();
        int total = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            Cow c = new Cow(w, x, d);
            finish.add(c);
            xpos.add(c);
            total += w;
        }
        br.close();
        xpos.sort((a, b) -> a.x - b.x);
        for(Cow c : xpos){
            if (c.d == -1) left.add(c);
            else right.add(c);
        }
        int x = 0;
        for(Cow c : left){
            xpos.get(x).time = c.x;
            x++;
        }
        for(Cow c : right){
            xpos.get(x).time = l-c.x;
            x++;
        }

        finish.sort((a, b) -> a.time - b.time);

        int curW = 0;
        int t = 0;
        for (Cow c : finish){
            curW += c.weight;
            if (curW*2 >= total){
                t = c.time;
                break;
            }
        }

        int ans = 0;
        Queue<Cow> rig = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (xpos.get(i).d == -1){
                while(!rig.isEmpty() && rig.peek().x + t*2 < xpos.get(i).x)
                    rig.poll();
                ans += rig.size();
            }else
                rig.add(xpos.get(i));
        }

        pw.println(ans);
        pw.close();
    }
}
