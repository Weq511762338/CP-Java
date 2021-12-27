//package Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class themoopractice {

    static class Particle{
        int x;
        int y;

        public Particle(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("moop.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moop.out")));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Particle> list = new ArrayList<>();
        for(int i = 0; i < n ;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Particle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list, (a, b) -> a.x -b.x == 0 ? a.y - b.y : a.x - b.x);
        br.close();
        int[] minL = new int[n+1];
        int[] maxR = new int[n+1];
        minL[1] = list.get(0).y;
        maxR[n] = list.get(n-1).y;

        for(int i = 2; i <= n; i++){
            minL[i] = Math.min(minL[i-1], list.get(i-1).y);
        }
        for(int i = n-1; i >= 1; i--){
            maxR[i] = Math.max(maxR[i+1], list.get(i-1).y);
        }

        int ans = 1;
        for(int i = 1; i < n; i++){
            if (minL[i] > maxR[i+1]) ans++;
        }

        pw.println(ans);
        pw.close();
    }
}
