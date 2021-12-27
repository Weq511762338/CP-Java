//package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class perimeter {
    static int[][] arr;
    static int area;
    static int pere;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("perimeter.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                arr[i][j] = s.charAt(j) == '#' ? 1 : 0;
            }
        }
        br.close();

        boolean[][] visited = new boolean[n][n];
        int maxA = 0;
        int maxP = 0;
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                area = 0;
                pere = 0;
                if (arr[i][j] == 1)ff(visited, i, j);
                if (area > maxA){
                    maxA = area;
                    maxP = pere;
                } else if (area == maxA) maxP = Math.min(maxP, pere);
            }
        }

        pw.println(maxA + " " + maxP);
        pw.close();
    }

    public static void ff(boolean[][] visited, int i, int j){
        if (visited[i][j] || arr[i][j] == 0) return;
        visited[i][j] = true;
        area++;
        if (i > 0 && arr[i-1][j] == 0 || i == 0) pere++;
        if (j > 0 && arr[i][j-1] == 0 || j == 0) pere++;
        if (i < n-1 && arr[i+1][j] == 0 || i == n-1) pere++;
        if (j < n-1 && arr[i][j+1] == 0 || j == n-1) pere++;

        if (i > 0) ff(visited, i-1, j);
        if (j > 0) ff(visited, i, j-1);
        if (i < n-1) ff(visited, i+1, j);
        if (j < n-1) ff(visited, i, j+1);
    }
}
