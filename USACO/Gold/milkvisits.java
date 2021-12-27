package Gold;

import java.io.*;
import java.util.*;


public class milkvisits {
    static int co = 0;
    static int[] depth;
    static ArrayList<Integer>[] todo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("milkvisits.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] pref = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            pref[i+1] = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for (int i = 0; i < n-1; i++) {
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(adj[a] == null)
                adj[a] = new ArrayList<>();
            if(adj[b] == null)
                adj[b] = new ArrayList<>();
            adj[a].add(b);
            adj[b].add(a);
        }
        ArrayList<Integer> nodes = new ArrayList<>();
        int[][] range = new int[n+1][2];
        depth = new int[n+1];

        dfs(0, adj, range, nodes, 1, 0);

        int[][] qFarm = new int[m][2];
        int[] qType = new int[m];
        todo = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) todo[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int type = Integer.parseInt(st.nextToken());

            qFarm[i][0] = a;
            qFarm[i][1] = b;
            todo[a].add(i);
            todo[b].add(i);
            qType[i] = type;
        }
        br.close();
        int[] ans = new int[m];
        HashMap<Integer, Stack<Integer>> check = new HashMap<>();

        dfs2(ans, check, qFarm, qType, pref, adj, range, nodes, 1, 0);

        for(Integer i : ans)
            pw.print(i);

        pw.println();
        pw.close();
    }

    public static void dfs2(int[] ans, HashMap<Integer, Stack<Integer>> check, int[][] qFarm, int[] qType, int[] pref, ArrayList<Integer>[] adj, int[][] range, ArrayList<Integer> nodes, int x, int y){
        if (!check.containsKey(pref[x])) check.put(pref[x], new Stack<>());
        check.get(pref[x]).add(x);
        nodes.add(x);
        for(Integer i : todo[x]) if (check.containsKey(qType[i]) && !check.get(qType[i]).isEmpty()){
            int fy = check.get(qType[i]).peek();
            if (fy == x) ans[i] = 1;
            else{
                int fY = nodes.get(depth[fy] + 1);
                if (!anc(range, fY, qFarm[i][0] + qFarm[i][1] - x)) ans[i] = 1;
            }
        }
        for(Integer i : adj[x]) if (i != y) dfs2(ans, check, qFarm, qType, pref, adj, range, nodes, i, x);
        check.get(pref[x]).pop();
        nodes.remove(nodes.size()-1);
    }

    public static void dfs(int dep, ArrayList<Integer>[] adj, int[][] range, ArrayList<Integer> nodes, int x, int y){
        depth[x] = dep;
        range[x][0] = co++;
        for(Integer i : adj[x]) if (i != y) dfs(dep+1, adj, range, nodes, i, x);
        range[x][1] = co-1;
    }

    public static boolean anc(int[][] range, int a, int b){
        return range[a][0] <= range[b][0] && range[a][1] >= range[b][1];
    }

}
