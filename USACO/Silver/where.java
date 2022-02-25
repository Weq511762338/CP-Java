//package Silver;


import java.io.*;
import java.util.ArrayList;
import java.util.TreeMap;

public class where {
    static int n;
    static boolean[][] visited;
    static int[][] grid;
    static TreeMap<Integer, Integer> map;

    public static class Pair{
        int i;
        int j;
        int x;
        int y;


        public Pair(int i, int j, int x, int y) {
            this.i = i;
            this.j = j;
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("where.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("where.out"));
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = str.charAt(j);
                grid[i][j] = c;
            }
        }
        br.close();

        ArrayList<Pair> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = i; k < n; k++) {
                    for (int l = j; l < n; l++) {
                        map = new TreeMap<>();
                        visited = new boolean[n][n];
                        for (int a = i; a <= k; a++) {
                            for (int b = j; b <= l; b++) {
                                if (!visited[a][b]){
                                    int color = grid[a][b];
                                    if (!map.containsKey(color)) map.put(color, 0);
                                    map.put(color, map.get(color) + 1);
                                }
                                ff(a, b, i, j, k, l, grid[a][b]);
                            }
                        }
                        if (map.size() == 2 && ((map.firstEntry().getValue() == 1 && map.lastEntry().getValue() > 1) || (map.firstEntry().getValue() > 1 && map.lastEntry().getValue() == 1)))
                            list.add(new Pair(i, j, k, l));
                    }
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < list.size(); i++){
            boolean valid = true;
            for (int j = 0; j < list.size(); j++) {
                if (i == j) continue;
                Pair p1 = list.get(i);
                Pair p2 = list.get(j);

                int i1 = p1.i;
                int j1 = p1.j;
                int x1 = p1.x;
                int y1 = p1.y;

                int i2 = p2.i;
                int j2 = p2.j;
                int x2 = p2.x;
                int y2 = p2.y;

                if (i2 <= i1 && j2 <= j1 && x2 >= x1 && y2 >= y1) {
                    valid = false;
                    break;
                }
            }
            if (valid) ans++;
        }

        pw.println(ans);
        pw.close();
    }

    public static void ff(int curx, int cury, int i, int j, int x, int y, int color){
        if (grid[curx][cury] != color) return;
        if (visited[curx][cury]) return;
        visited[curx][cury] = true;

        if (curx > i) ff(curx -1, cury, i, j, x, y, color);
        if (curx < x) ff(curx +1, cury, i, j, x, y, color);
        if (cury > j) ff(curx, cury -1, i, j, x, y, color);
        if (cury < y) ff(curx , cury+1, i, j, x, y, color);
    }

}
