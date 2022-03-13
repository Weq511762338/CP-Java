import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.StringTokenizer;

public class GridWalk {

    static boolean[][] holes;
    static int i;
    static int j;
    static int p;
    static BigInteger count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        i = Integer.parseInt(st.nextToken());
        j = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        count = new BigInteger("0");
        holes = new boolean[i+1][j+1];
        for(int a = 0; a < p; a ++){
            st  = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            holes[x][y] = true;
        }
        br.close();

        sol(0, 0);
        pw.println(count);
        pw.close();
    }

    public static void sol(int x, int y){
        if (x == i && y == j){
            count = count.add(new BigInteger("1"));
            return;
        }

        if (x < i && !holes[x+1][y]) sol(x+1, y);
        if (y < j && !holes[x][y+1]) sol(x, y+1);
    }
}