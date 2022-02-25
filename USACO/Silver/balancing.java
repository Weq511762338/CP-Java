//package Silver;

import java.io.*;
import java.util.*;

public class balancing {


    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("balancing.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));

        int n = Integer.parseInt(br.readLine());
        int[] xs = new int[n];
        int[] ys = new int[n];
        Integer[] cow = new Integer[n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            xs[i] = a;
            ys[i] =b;
            cow[i] = i;
        }
        br.close();

        Arrays.sort(cow, Comparator.comparingInt(a -> xs[a]));
        int x = 1;
        for(int i= 0; i < n; i++){
            xs[cow[i]] = x;
            x += 2;
        }

        Arrays.sort(cow, Comparator.comparingInt(a -> ys[a]));
        int y = 1;
        for(int i= 0; i < n; i++){
            ys[cow[i]] = y;
            y += 2;
        }

        int[][] farm = new int[2*n+1][2*n+1];
        for(int i= 0; i < n; i++){
            farm[ys[i]][xs[i]] ++;
        }
        for(int i= 0; i <= 2*n; i++){
            for(int j = 0; j <= 2*n; j++){
                if (i > 0) farm[i][j] += farm[i-1][j];
                if (j > 0) farm[i][j] += farm[i][j-1];
                if (i > 0 && j > 0) farm[i][j] -= farm[i-1][j-1];
            }
        }

        int ans = n;
        for(int i= 0; i <= 2*n; i += 2){
            for(int j= 0; j <= 2*n; j += 2){
                TreeSet<Integer> set = new TreeSet<>();
                set.add(compute(farm, i, j, 0, 0));
                set.add(compute(farm, i, 2*n, 0, j));
                set.add(compute(farm, 2*n, j, i, 0));
                set.add(compute(farm, 2*n, 2*n, i, j));
                ans = Math.min(ans, set.pollLast());
            }
        }

        pw.println(ans);
        pw.close();
    }

    public static int compute(int[][] arr, int fromi, int fromj, int  toi, int toj){
        return arr[toi][toj] - arr[toi][fromj] - arr[fromi][toj] + arr[fromi][fromj];
    }
}
