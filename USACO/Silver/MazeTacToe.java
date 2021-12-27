//package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class MazeTacToe {
    static char[][][] board;
    static HashSet<Integer> ans = new HashSet<>();
    static boolean[][][] reached;
    static int[] pow3 = new int[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        board = new char[n][n][3];
        reached = new boolean[n][n][19683];
        int bx = -1;
        int by = -1;
        pow3[0] = 1;
        for (int i=1; i<=9; i++) pow3[i] = pow3[i-1]*3;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                String sym = s.substring(j*3, (j+1)*3);
                board[i][j][0] = sym.charAt(0);
                board[i][j][1] = sym.charAt(1);
                board[i][j][2] = sym.charAt(2);
                if (board[i][j][0] == 'B'){bx = i; by = j;}
            }
        }
        br.close();
        ff(bx, by, 0);
        System.out.println(ans.size());
     }

     public static void ff(int i, int j, int b){
        if (reached[i][j][b]) return;
        reached[i][j][b] = true;

        if(board[i][j][0] == 'M' || board[i][j][0] == 'O'){
            int r = board[i][j][1]-'1';
            int c = board[i][j][2]-'1';
            int index = r*3+c;
            int current_char = (b / pow3[index]) % 3; // base 3
            if (current_char == 0) {
                int new_char = board[i][j][0]=='M' ? 1 : 2;
                //  part on the right       part to add             part on the left
                b = (b % pow3[index]) + new_char * pow3[index] + (b - b % pow3[index+1]); // combine them
                if (!reached[i][j][b] && win(b)) { ans.add(b); return; }
                reached[i][j][b] = true;
            }


        }

         if (board[i-1][j][0] != '#') ff(i-1,j,b);
         if (board[i+1][j][0] != '#') ff(i+1,j,b);
         if (board[i][j-1][0] != '#') ff(i,j-1,b);
         if (board[i][j+1][0] != '#') ff(i,j+1,b);
     }
    public static boolean win(int b)
    {
        int[][] cells = new int[3][3];
        for (int i=0; i<3; i++)
            for (int j=0; j<3; j++) {
                cells[i][j] = b%3;
                b /= 3;
            }
        for (int r=0; r<3; r++) {
            if (cells[r][0] == 1 && cells[r][1] == 2 && cells[r][2] == 2) return true;
            if (cells[r][0] == 2 && cells[r][1] == 2 && cells[r][2] == 1) return true;
        }
        for (int c=0; c<3; c++) {
            if (cells[0][c] == 1 && cells[1][c] == 2 && cells[2][c] == 2) return true;
            if (cells[0][c] == 2 && cells[1][c] == 2 && cells[2][c] == 1) return true;
        }
        if (cells[0][0] == 1 && cells[1][1] == 2 && cells[2][2] == 2) return true;
        if (cells[0][0] == 2 && cells[1][1] == 2 && cells[2][2] == 1) return true;
        if (cells[2][0] == 1 && cells[1][1] == 2 && cells[0][2] == 2) return true;
        if (cells[2][0] == 2 && cells[1][1] == 2 && cells[0][2] == 1) return true;
        return false;
    }
}
