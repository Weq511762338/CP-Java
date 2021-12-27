//package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MessageRoute {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer>[] adj = new LinkedList[n+1];

        for (int i = 1; i <=n ; i++) {
            adj[i] = new LinkedList<>();
        }
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        br.close();

        int[] parent = new int[n+1];
        int[] dis = new int[n+1];
        Queue<Integer> bfs = new LinkedList<>();
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1] = 1;
        bfs.add(1);
        while(!bfs.isEmpty()){
            int comp = bfs.poll();
            for (int i = 1; i <= adj[comp].size(); i++) {
                int node = adj[comp].get(i-1);
                if (node != parent[comp]){
                    if (dis[node] > dis[comp] + 1) {
                        parent[node] = comp;
                        dis[node] = dis[comp] + 1;
                        bfs.add(node);
                    }
                }
            }
        }
        if (dis[n] == Integer.MAX_VALUE)
            System.out.println("IMPOSSIBLE");
        else {
            System.out.println(dis[n]);
            ArrayList<Integer> route = new ArrayList<>();
            int comp = n;
            while(comp != 1){
                route.add(comp);
                comp = parent[comp];
            }
            System.out.print(1 + " ");
            for (int i = route.size()-1; i > 0; i--) {
                System.out.print(route.get(i) + " ");
            }
            System.out.println(route.get(0));
        }


    }
}
