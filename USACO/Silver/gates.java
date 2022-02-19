//package Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class gates {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("gates.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gates.out")));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        br.close();

        HashSet<Character>[][] grid = new HashSet[2001][2001];
        int row = 1000;
        int col = 1000;

        int ans = 0;
        for(int i = 0; i < n ;i++){
            char c = str.charAt(i);
            if (grid[row][col] == null) grid[row][col] = new HashSet<>();
            switch (c){
                case 'N':
                    if (!grid[row][col].contains('N') && grid[row-1][col] != null) ans++;
                    grid[row][col].add('N');
                    row--;
                    if (grid[row][col] == null) grid[row][col] = new HashSet<>();
                    grid[row][col].add('S');
                    break;
                case 'S':
                    if (!grid[row][col].contains('S') && grid[row+1][col] != null) ans++;
                    grid[row][col].add('S');
                    row++;
                    if (grid[row][col] == null) grid[row][col] = new HashSet<>();
                    grid[row][col].add('N');
                    break;
                case 'E':
                    if (!grid[row][col].contains('E') && grid[row][col+1] != null) ans++;
                    grid[row][col].add('E');
                    col++;
                    if (grid[row][col] == null) grid[row][col] = new HashSet<>();
                    grid[row][col].add('W');
                    break;
                case 'W':
                    if (!grid[row][col].contains('W') && grid[row][col-1] != null) ans++;
                    grid[row][col].add('W');
                    col--;
                    if (grid[row][col] == null) grid[row][col] = new HashSet<>();
                    grid[row][col].add('E');
                    break;
            }
        }
        pw.println(ans);
        pw.close();

    }
}
