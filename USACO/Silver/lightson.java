//package Silver;

import java.io.*;
import java.util.*;

public class lightson {
    static class Room{
        int x;
        int y;

        public Room(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean[][] lit;
    static boolean[][] visited;
    static ArrayList<Room>[][] list;

    static int ans;
    static HashMap<Integer, ArrayList<Integer>> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lightson.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        ans = 1;
        lit = new boolean[n+1][n+1];
        visited = new boolean[n+1][n+1];
        list = new ArrayList[n+1][n+1];
        for(int i= 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (list[a][b] == null) list[a][b] = new ArrayList<>();
            list[a][b].add(new Room(c, d));
        }
        br.close();

        lit[1][1] = true;
        ff(1, 1);
        pw.println(ans);
        pw.close();
    }

    public static void ff(int i, int j){
        if (!lit[i][j]) return;
        if (visited[i][j]) return;
        visited[i][j] = true;
        if (list[i][j] != null) {
            for (Room r : list[i][j]) {
                if (!lit[r.x][r.y]) ans++;
                lit[r.x][r.y] = true;
                if (!visited[r.x][r.y]){
                    if (r.x > 1 && visited[r.x-1][r.y]) ff(r.x, r.y);
                    else if (r.x < lit.length-1 && visited[r.x+1][r.y]) ff(r.x, r.y);
                    else if (r.y > 1 && visited[r.x][r.y-1]) ff(r.x, r.y);
                    else if (r.y < lit.length-1 && visited[r.x][r.y+1]) ff(r.x, r.y);
                }
            }
        }

        if (i > 1) ff(i -1,j);
        if (i < lit.length-1) ff(i + 1, j);
        if (j > 1) ff(i, j-1);
        if (j < lit.length-1) ff(i, j+1);
    }
}
