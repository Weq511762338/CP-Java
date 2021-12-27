//package Silver;

import java.io.*;

public class leftout {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br= new BufferedReader(new FileReader("leftout.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("leftout.out")));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j  <n; j++){
                arr[i][j] = s.charAt(j) == 'L' ? 1 : 0;
            }
        }
        br.close();

        for(int i = 0; i < n; i++){
            if (arr[0][i] == 1) {
                for (int j = 0; j < n; j++) {
                    arr[j][i] = (arr[j][i]+1)%2;
                }
            }
        }
        for(int i = 0; i < n; i++){
            if (arr[i][0] == 1) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = (arr[i][j]+1)%2;
                }
            }
        }

        boolean isDone = false;
        if (count(1, 1, n-1, n-1, 0) == 0)
            pw.println(1 + " " + 1);
        else if (count (1,1,n-1,n-1,1) == n-1) {
            for (int j=1; j<n; j++) if (count(1,j,n-1,j,1)==n-1) {
                pw.println("1 " + (j + 1));
                isDone =true;
                break;
            }
            if (!isDone)
                for (int i=1; i<n; i++) if (count(i,1,i,n-1,1)==n-1) {
                    pw.println((i + 1) + " 1");
                    break;
                }
        } else if (count(1, 1, n-1, n-1, 1) != 1) pw.println(-1);
        else {
            l:
            for (int i = 1; i < n; i++)
                for (int j = 1; j < n; j++)
                    if (arr[i][j] == 1) {
                        pw.println((i + 1) + " " + (j + 1));
                        break l;
                    }
        }
        pw.close();
    }

    public static int count(int a, int b, int x, int y, int mark){
        int c = 0;
        for(int i = a; i <= x; i++){
            for (int j = b; j <= y; j++) {
                if (arr[i][j] == mark) c++;
            }
        }
        return c;
    }
}
