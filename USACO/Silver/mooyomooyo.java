//package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class mooyomooyo {
    static int count = 0;
    static boolean isfinal = false;
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mooyomooyo.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mooyomooyo.out")));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][10];
        for(int i = 0 ; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < 10; j++) arr[i][j] = Integer.parseInt(s.substring(j, j+1));
        }
        br.close();


        while(!isfinal){
            boolean[][] visited = new boolean[n][10];
            count = 0;
            isfinal = true;
            for(int i = 0; i < n;i++){
                for (int j = 0; j < 10; j++) {
                    count = 0;
                    if (arr[i][j] != 0){
                        ff(visited, arr, i, j);
                        if(count >= k){
                            isfinal = false;
                            update(arr, i, j, arr[i][j]);
                        }
                    }
                }
            }

            for(int j = 0; j < 10; j++){
                int top = n-1;
                int bot = n-1;
                while(top >= 0) {
                    while (top >= 0 && arr[top][j] == 0) top--;
                    if (top >= 0)  arr[bot--][j] = arr[top--][j];
                }
                while(bot >= 0) arr[bot--][j] = 0;
            }
        }

        for(int i = 0; i < n; i++){
            for (int j = 0; j < 10; j++) {
                pw.print(arr[i][j]);
            }
            pw.println();
        }
        pw.close();
    }

    public static void ff(boolean[][] visited, int[][] arr, int i, int j){
        if (visited[i][j]) return;
        visited[i][j] = true;
        count++;
        if (i > 0 && arr[i][j] == arr[i-1][j]) ff(visited, arr, i-1, j);
        if (j > 0 && arr[i][j] == arr[i][j-1]) ff(visited, arr, i, j-1);
        if (i < n-1 && arr[i][j] == arr[i+1][j]) ff(visited, arr, i+1, j);
        if (j < 9 && arr[i][j] == arr[i][j+1]) ff(visited, arr, i, j+1);
    }
    public static void update(int[][] arr, int i, int j, int color){
        arr[i][j] = 0;
        if (i > 0 && color == arr[i-1][j]) update(arr, i-1, j, color);
        if (j > 0 && color == arr[i][j-1]) update(arr, i, j-1, color);
        if (i < n-1 && color == arr[i+1][j]) update(arr, i+1, j, color);
        if (j < 9 && color == arr[i][j+1]) update(arr, i, j+1, color);
    }
}
