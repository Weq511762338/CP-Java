//package Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class countcross {
    static HashSet<Character>[][] list;
    static boolean[][] visited;
    static int[][] grid;
    static int count;
    static int n, k, r;
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("countcross.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("countcross.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         k = Integer.parseInt(st.nextToken());
         r = Integer.parseInt(st.nextToken());

        list = new HashSet[n+1][n+1];
        visited = new boolean[n+1][n+1];
        grid = new int[n+1][n+1];
        count = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (list[a][b] == null)
                list[a][b] = new HashSet<>();
            if (list[c][d] == null)
                list[c][d] = new HashSet<>();
            if (a == c){
                list[a][b].add(b < d ? 'U' : 'D');
                list[c][d].add(b < d ? 'D' : 'U');
            }else {
                list[a][b].add(a < c ? 'R' : 'L');
                list[c][d].add(a < c ? 'L' : 'R');
            }
        }
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            grid[a][b]++;
        }
        br.close();
        for(int i = 1 ; i <= n; i++){
            for(int j = 1 ; j  <= n; j++){
                count = 0;
                ff(i, j);
                ans.add(count);
            }
        }

        long res = 0;
        for(int i = 0; i < ans.size(); i++){
            for(int j = i+1; j < ans.size(); j++){
                res += (long) ans.get(i) *ans.get(j);
            }
        }
        pw.println(res);
        pw.close();
    }

    public static void ff(int x, int y){
        if (visited[x][y]) return;
        visited[x][y] = true;
        count += grid[x][y];

        if (x-1 > 0 && (list[x][y] == null || !list[x][y].contains('L'))) ff(x-1, y);
        if (y-1 > 0 && (list[x][y] == null || !list[x][y].contains('D'))) ff(x, y-1);
        if (x+1 <= n && (list[x][y] == null || !list[x][y].contains('R'))) ff(x+1, y);
        if (y+1 <= n && (list[x][y] == null || !list[x][y].contains('U'))) ff(x, y+1);
    }

}
