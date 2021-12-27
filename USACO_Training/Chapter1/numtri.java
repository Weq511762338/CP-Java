/*
ID: weq51171
LANG: JAVA
TASK: numtri
 */

//package USACO_Training.Chapter1;


import java.io.*;
import java.util.StringTokenizer;

public class numtri {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("numtri.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));

        int r = Integer.parseInt(br.readLine());
        int[][] list = new int[r][r];
        int[][] visited = new int[r][r];

        StringTokenizer st;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; st.hasMoreTokens(); j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = -1;
            }
        }
        br.close();

        pw.println(dfs(r, list, 0, 0, visited));
        pw.close();
    }

    public static int dfs (int r, int[][] tree, int i, int j, int[][] visited){

        if (i == r){
            return 0;
        }
        if (visited[i][j] != -1)
            return visited[i][j];

        visited[i][j] = tree[i][j] + Math.max(dfs(r, tree, i+1, j, visited), dfs(r, tree, i+1, j+1, visited));
        return visited[i][j];
    }
}