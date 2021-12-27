//package Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
public class wormsort {

    static int[] parent;
    static int[] size;

    public static class Path{
        int a;
        int b;
        int w;

        public Path(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);

        BufferedReader br = new BufferedReader(new FileReader("wormsort.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("wormsort.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        size = new int[n+1];
        Arrays.fill(size, 1);
        int[] cow = new int[n+1];
        ArrayList<Integer> unsorted = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            parent[i+1] = i+1;
            cow[i+1] = num;
            if (num != i+1) unsorted.add(i+1);
        }
        ArrayList<Path> wormhole = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            wormhole.add(new Path(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        br.close();
        if (unsorted.isEmpty())
            pw.println(-1);
        else{
            Collections.sort(wormhole, (a, b)->a.w - b.w);

            int l = 0;
            int r = wormhole.size()-1;
            while(l < r) {
                int mid = (l + r + 1)/2;

                System.out.println("====" + wormhole.get(mid).w);

                boolean valid = true;
                for (int i = mid; i < m; i++) {
                    Path p = wormhole.get(i);
                    union(p.a, p.b);
                }
                for (int a : unsorted) {
                    if (get(cow[a]) != get(a)) {
                        valid = false;
                        break;
                    }
                }


                if (valid)
                    l = mid;
                else
                    r = mid - 1;

                for(int i = 1; i <= n; i++) parent[i] = i;
                Arrays.fill(size, 1);
            }

            pw.println(wormhole.get(l).w);
        }
        pw.close();

    }

    public static void union(int a, int b) {
        int pa = get(a);
        int pb = get(b);

        if (size[pa] < size[pb]) {
            parent[pa] = pb;
            size[pb] += size[pa];
        } else {
            parent[pb] = pa;
            size[pa] += size[pb];
        }
    }

    public static int get(int a){
        if (a != parent[a])
            parent[a] = get(parent[a]);

        return parent[a];
    }
}
