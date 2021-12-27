//package Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class revegetate {
    static int[] pasture;
    static boolean isPossible;
    static ArrayList<Integer>[] adjS;
    static ArrayList<Integer>[] adjD;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("revegetate.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        pasture = new int[n + 1];
        isPossible = true;
        adjS = new ArrayList[n+1];
        adjD = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) adjS[i] = new ArrayList<>();
        for(int i = 0; i <= n; i++) adjD[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (s.equals("S")){
                adjS[a].add(b);
                adjS[b].add(a);
            } else{
                adjD[a].add(b);
                adjD[b].add(a);
            }
        }
        int count = 0;
        for(int i = 1; i <= n; i++ ){
            if (!isPossible)break;
            if (pasture[i] == 0){
                bfs(i, 1);
                count++;
            }
        }
        if (isPossible){
            pw.print(1);
            for(int i = 0; i < count; i++) pw.print(0);
        }else
            pw.print(0);
        pw.println();
        pw.close();
    }
    public static void bfs(int i, int mark){
        pasture[i] = mark;
        for(int a : adjS[i]){
            if (!isPossible) return;
            if (pasture[a] != 0 && pasture[a] != pasture[i]){
                isPossible = false;
                return;
            }
            if (pasture[a] == 0) bfs(a, mark);
        }
        for(int a : adjD[i]){
            if (!isPossible) return;
            if (pasture[a] != 0 && pasture[a] == pasture[i]){
                isPossible = false;
                return;
            }
            if (pasture[a] == 0) bfs(a, 3-mark);
        }
    }
}
