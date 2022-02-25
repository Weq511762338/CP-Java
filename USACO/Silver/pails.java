//package Silver;

import java.io.*;
import java.util.*;

public class pails {

    static int[][] arr;
    static int x;
    static int y;
    static int k;
    static int m;
    public static void main(String[] args) throws IOException {
//        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("pails.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("pails.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
         x = Integer.parseInt(st.nextToken());
         y = Integer.parseInt(st.nextToken());
         k = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
        br.close();
        arr = new int[201][201];
        for(int i = 0; i < 201; i++) {
            for (int j = 0; j < 201; j++) {
                arr[i][j] = -1;
            }
        }
        sim(0, 0, 0);

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < 201; i++) {
            for (int j = 0; j < 201; j++) {
                if (arr[i][j] != -1){
                    ans = Math.min(ans, Math.abs(m-(i+j)));
                }
            }
        }
        pw.println(ans);
        pw.close();
    }

    public static void sim(int a, int b, int times){
        if (times > k) return;
        if (arr[a][b] != -1 && arr[a][b] <= times) return;
        arr[a][b] = times;

        sim(x, b, times+1);
        sim(a, y, times+1);
        sim(0, b, times+1);
        sim(a, 0, times+1);
        int apb = Math.min(a, y-b);
        sim(a - apb, b + apb, times+1);
        int bpa = Math.min(b, x-a);
        sim(a + bpa, b - bpa, times+1);
    }
}
