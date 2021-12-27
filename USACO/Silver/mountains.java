//package Silver;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class mountains {
    static class Peak{
        int x;
        int y;

        public Peak(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mountains.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        ArrayList<Peak> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Peak(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        br.close();
        Collections.sort(list, (a,b) -> a.y == b.y ? a.x - b.x : a.y - b.y);
        for(int i = list.size()-1; i >= 0; i--){
            Peak a = list.get(i);
            for(int j = i-1; j >= 0; j--){
                Peak b = list.get(j);
//                if (b.y <= a.y && b.x <= a.x + a.y && b.x >= a.x - a.y) list.remove(j);
                int left = a.x - a.y;
                int right = a.x  + a.y;
                if (Math.min(b.x - left, right - b.x) >= b.y){
                    list.remove(j);
                    i--;
                }
            }
        }
        pw.println(list.size());
        pw.close();
    }
}
