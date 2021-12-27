//package Gold;

import java.io.*;
import java.util.*;

public class MilkPumping {

    static class EdgeEnd{
        int b;
        int cost;
        int fr;

        public EdgeEnd(int b, int cost, int fr){
            this.b = b;
            this.cost = cost;
            this.fr = fr;
        }
    }
//    public static void main(String[] args) throws IOException {
////        BufferedReader br = new BufferedReader(new FileReader("pump.in"));
////        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pump.out")));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st. nextToken());
//
//
//        ArrayList<EdgeEnd>[] adj = new ArrayList[n+1];
//        for (int i = 0; i < m; i++) {
//            st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            int cost = Integer.parseInt(st.nextToken());
//            int fr = Integer.parseInt(st.nextToken());
//
//            if (adj[a] == null)
//                adj[a] = new ArrayList<>();
//            adj[a].add(new EdgeEnd(b, cost, fr));
//            if (adj[b] == null)
//                adj[b] = new ArrayList<>();
//            adj[b].add(new EdgeEnd(a, cost, fr));
//        }
//        br.close();
//
//        double[] bestFr = new double[n+1];
//        double[] bestWeight = new double[n+1];
//
//        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->  Double.compare(bestFr[a]/bestWeight[a], bestFr[b]/bestWeight[b]));
//
//        Arrays.fill(bestWeight, 1);
////        Arrays.fill(bestFr, 0);
//        bestFr[1] = Integer.MAX_VALUE;
//        bestWeight[1] = 0;
//        pq.add(1);
//        while(!pq.isEmpty()){
//            int node = pq.poll();
//            for (int i = 0; i < adj[node].size(); i++) {
//                EdgeEnd edge = adj[node].get(i);
//                if (Math.min(bestFr[node], edge.fr)/(bestWeight[node] + edge.cost) > bestFr[edge.b]/ bestWeight[edge.b]){
//                    bestWeight[edge.b] = bestWeight[node] + edge.cost;
//                    bestFr[edge.b] = Math.min(bestFr[node], edge.fr);
//                    pq.remove(i);
//                    pq.add(edge.b);
//                }
//            }
//        }
//
////        pw.println(Arrays.toString(bestFr));
////        pw.println(Arrays.toString(bestWeight));
//        pw.println((int)((bestFr[n]/bestWeight[n]) *1000000));
//        pw.close();
//
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("pump.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pump.out")));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st. nextToken());


        ArrayList<EdgeEnd>[] adj = new ArrayList[n+1];

        TreeSet<Integer> weight = new TreeSet<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            int fr = Integer.parseInt(st.nextToken());

            weight.add(fr);

            if (adj[a] == null)
                adj[a] = new ArrayList<>();
            adj[a].add(new EdgeEnd(b, cost, fr));
            if (adj[b] == null)
                adj[b] = new ArrayList<>();
            adj[b].add(new EdgeEnd(a, cost, fr));
        }
        br.close();

        int ans = 0;
        int[] bestFr = new int[n+1];
        int[] bestWeight = new int[n+1];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (bestWeight[a] - bestWeight[b]));
        do {
            Arrays.fill(bestWeight, Integer.MAX_VALUE);
            Arrays.fill(bestFr, Integer.MAX_VALUE);
            bestWeight[1] = 0;
            pq.add(1);
            while (!pq.isEmpty()) {
                int node = pq.poll();
                for (int i = 0; i < adj[node].size(); i++) {
                    EdgeEnd edge = adj[node].get(i);
                    if (bestWeight[edge.b] > bestWeight[node] + edge.cost) {
                        bestWeight[edge.b] = bestWeight[node] + edge.cost;
                        bestFr[edge.b] = Math.min(bestFr[node], edge.fr);
                        pq.add(edge.b);
                    }
                }
            }
            if (bestFr[n] != Integer.MAX_VALUE)
                ans = Math.max(ans, (int)(((double)bestFr[n]/(double)bestWeight[n])*1000000));

            int frToRemove = weight.pollFirst();

            for (int i = 1; i <= n; i++) {
                if (adj[i] != null){
                    int index = 0;
                    for (int j = 0; j < adj[i].size(); j++) {
                        if (adj[i].get(index).fr == frToRemove){
                            adj[i].remove(index);
                            index--;
                        }
                        index++;
                    }
                }
            }
        } while(bestWeight[n] != Integer.MAX_VALUE || !weight.isEmpty());

//        pw.println(Arrays.toString(bestFr));
//        pw.println(Arrays.toString(bestWeight));
        pw.println(ans);
        pw.close();

    }
}
