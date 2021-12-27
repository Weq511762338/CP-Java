//package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class stuckinarut {
    static class Cow{
        int x;
        int y;
        String dir;
        ArrayList<Cow> stopped;
        boolean isStopped;

        public Cow(int x, int y, String dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            stopped = new ArrayList<>();
            isStopped = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());

        ArrayList<Cow> list = new ArrayList<>();
        ArrayList<Cow> north = new ArrayList<>();
        ArrayList<Cow> east = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String dir = st.nextToken();
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Cow c = new Cow(x, y, dir);
            list.add(c);
            if (dir.equals("E")) east.add(c);
            else north.add(c);
        }
        br.close();
        Collections.sort(north, (a, b)-> a.x-b.x);
        Collections.sort(east, (a, b) -> a.y- b.y);
        int[] ans = new int[n+1];

        for(Cow cN : north){
            for(Cow cE : east){
                if (cN.x >= cE.x && cN.y <= cE.y && !cE.isStopped){
                    if (cN.x-cE.x < cE.y - cN.y){
                        cN.isStopped = true;
                        cE.stopped.add(cN);
                        break;
                    } else if (cN.x-cE.x > cE.y - cN.y){
                        cE.isStopped = true;
                        cN.stopped.add(cE);
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            pw.println(getCount(list.get(i-1)));
        }
        pw.close();
    }

    public static int getCount(Cow cow){
        int count = cow.stopped.size();
        for(Cow c : cow.stopped)
            count += getCount(c);
        return count;
    }
}
