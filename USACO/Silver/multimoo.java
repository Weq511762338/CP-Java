//package Silver;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class multimoo {
    static int ans1;
    static int ans2;
    static int count;
    static int[][] arr;
    static boolean[][] visited;
    static int n;
    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("multimoo.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("multimoo.out"));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count = 0;
                ff(arr[i][j], i, j);
                ans1 = Math.max(ans1, count);
            }
        }

        int last = arr[0][0];
        loop: for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if(ans2 == n*n) break loop; // case 9

                if (last != arr[i][j+1]){
                    count = 0;
                    ff(arr[i][j], arr[i][j+1], i, j);
                    ans2 = Math.max(ans2, count);
                    visited = new boolean[n][n];
                }
                last = arr[i][j+1];
            }
        }

        pw.println(ans1);
        pw.println(ans2);
        pw.close();
    }


    public static void ff(int id, int x, int y){
        if (visited[x][y] || arr[x][y] != id) return;
        visited[x][y] = true;
        count++;

        if (x > 0) ff(id, x-1, y);
        if (x < n-1) ff(id, x+1, y);
        if (y > 0) ff(id, x, y-1);
        if (y < n-1) ff(id, x, y+1);
    }

    public static void ff(int id1, int id2, int x, int y){
        if (visited[x][y] || (arr[x][y] != id1 && arr[x][y] != id2)) return;
        visited[x][y] = true;
        count++;

        if (x > 0) ff(id1, id2, x-1, y);
        if (x < n-1) ff(id1, id2, x+1, y);
        if (y > 0) ff(id1, id2, x, y-1);
        if (y < n-1) ff(id1, id2, x, y+1);
    }
/*    static class Graph {
        HashMap<Integer, HashSet<Integer>> edges;
        HashMap<Integer, Integer> nodesize, regid, regsize;

        public Graph(HashMap<Integer, HashSet<Integer>> edges, HashMap<Integer, Integer> size, HashMap<Integer, Integer> regid, HashMap<Integer, Integer> regsize) {
            this.edges = edges;
            this.nodesize = size;
            this.regid = regid;
            this.regsize = regsize;
        }
    }

    static int globalRegid = 0;
    static int[][] arr;
    static int[][] cellid;
    static HashMap<Integer, Graph> g1 = new HashMap<>(); // Graphs for all possible single IDs
    static HashMap<String, Graph> g2 = new HashMap<>(); // Graphs for all possible adjacent region pairs

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("multimoo.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("multimoo.out"));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        cellid = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                cellid[i][j] = i * n + j;

                g1.put(arr[i][j], new Graph(new HashMap<>(), new HashMap<>(), new HashMap<>(), new HashMap<>()));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                addEdge(g1.get(arr[i][j]), cellid[i][j], cellid[i][j]);
                if (i < n - 1 && arr[i + 1][j] == arr[i][j]) addEdge(g1.get(arr[i][j]), cellid[i][j], cellid[i + 1][j]);
                if (j < n - 1 && arr[i][j + 1] == arr[i][j]) addEdge(g1.get(arr[i][j]), cellid[i][j], cellid[i][j + 1]);
            }
        }

        int ans1 = 0;
        for (Map.Entry<Integer, Graph> entry : g1.entrySet()) {
            ans1 = Math.max(ans1, largestReg(entry.getValue()));
        }

        for(int i = 0; i < n ; i++){
            for (int j = 0; j < n; j++) {
                if (i < n-1 && arr[i+1][j] != arr[i][j]) addEdge2(i,j,i+1,j);
                if (j < n-1 && arr[i][j+1] != arr[i][j]) addEdge2(i,j,i,j+1);
            }
        }

        int ans2 = 0;
        for (Map.Entry<String, Graph> entry : g2.entrySet()) {
            ans2 = Math.max(ans2, largestReg(entry.getValue()));
        }

        pw.println(ans1);
        pw.println(ans2);
        pw.close();

    }
    public static void addEdge(Graph g, int node1, int node2) {
        if (!g.edges.containsKey(node1))
            g.edges.put(node1, new HashSet<>());
        if (!g.edges.containsKey(node2))
            g.edges.put(node2, new HashSet<>());
        g.edges.get(node1).add(node2);
        g.edges.get(node2).add(node1);
        g.nodesize.put(node1, 1);
        g.nodesize.put(node2, 1);
    }

    public static int largestReg(Graph g) {
        int m = 0;
        for (Map.Entry<Integer, HashSet<Integer>> entry : g.edges.entrySet())
            m = Math.max(m, visit(g, entry.getKey(), ++globalRegid));
        return m;
    }

    public static int visit(Graph g, int nodeid, int regid){
        if (g.regid.containsKey(nodeid)) return 0;
        g.regid.put(nodeid, regid);
        int a = g.nodesize.get(nodeid);
        for(int i : g.edges.get(nodeid))
            a += visit(g, i, regid);
        g.regsize.put(regid, a);
        return a;
    }

    public static void addEdge2(int i1, int j1, int i2, int j2){
        int b1 = arr[i1][j1];
        int b2 = arr[i2][j2];
        int c1 = cellid[i1][j1];
        int c2 = cellid[i2][j2];
        if (b1 > b2){
            int t = b2;
            b2 = b1;
            b1 = t;
            t = c2;
            c2 = c1;
            c1 = t;
        }
        int r1 = g1.get(b1).regid.get(c1);
        int r2 = g1.get(b2).regid.get(c2);
        String p = b1 + " " + b2;
        if (!g2.containsKey(p))
            g2.put(p, new Graph(new HashMap<>(), new HashMap<>(), new HashMap<>(), new HashMap<>()));
        addEdge(g2.get(p), r1, r2);
        g2.get(p).nodesize.put(r1, g1.get(b1).regsize.get(r1));
        g2.get(p).nodesize.put(r2, g1.get(b2).regsize.get(r2));
    }*/
}