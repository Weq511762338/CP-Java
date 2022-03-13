//package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class p2 {
    public static class Command{
        int x;
        int y;

        public Command(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n;
    static int x;
    static int y;
    static ArrayList<Command> list;
    static int count;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        n  = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i = 0; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new Command(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        br.close();
        ans = new int[n+1];
        count = 0;

        sol(0, 0, 0);
        for(int i = 1; i <= n; i++)
            pw.println(ans[i]);
        pw.close();
    }

    public static void sol(int xpos, int ypos, int index){
        if (xpos == x && ypos == y){
            ans[count]++;
        }
        for(int i = index; i < n; i++){
            count++;
            sol(xpos + list.get(i).x, ypos + list.get(i).y, i+1);
            count--;
        }
    }
}
