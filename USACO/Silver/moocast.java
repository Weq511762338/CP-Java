//package Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class moocast {

    static class Cow{
        int x;
        int y;
        int radius;

        public Cow(int x, int y, int radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
        }
    }


    static ArrayList<Integer>[] adj;
    static HashSet<Integer> visited;
    static int max;
    static int count;
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("moocast.out"));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Cow> list = new ArrayList<>();
        adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int radius = Integer.parseInt(st.nextToken());
            list.add(new Cow(x, y, radius));
            adj[i] = new ArrayList<>();
        }
        br.close();

        //constructing the graph
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Cow c1 = list.get(i);
                Cow c2 = list.get(j);
                if (inRange(c1, c2))
                    adj[i].add(j);
            }
        }

        //traversing the graph
        max = 0;

        for (int i = 0; i < n; i++) {
            count = 0;
            visited = new HashSet<>();
            traverse(i);
            max = Math.max(max, count);
        }
        pw.println(max);
        pw.close();
    }

    public static void traverse(int id){
        if (visited.contains(id))
            return;
        visited.add(id);
        count++;
        for(int i : adj[id]){
            traverse(i);
        }
    }

    //can cow1 reach cow2
    public static boolean inRange(Cow c1, Cow c2){
        int x1 = c1.x;
        int y1 = c1.y;
        int r1 = c1.radius;
        int x2 = c2.x;
        int y2 = c2.y;
        int r2 = c2.radius;

        int disx = Math.abs(x1-x2);
        int disy = Math.abs(y1-y2);
        long dis = disx*disx + disy*disy;
        return r1*r1 >= dis;
    }
}
