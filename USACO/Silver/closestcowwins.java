//package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class closestcowwins {
    public static class Grass{
        int pos;
        int val;

        public Grass(int pos, int val) {
            this.pos = pos;
            this.val = val;
        }

        public Grass(int pos){
            this.pos = pos;
            val = 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        TreeSet<Grass> grass = new TreeSet<>(Comparator.comparingInt(a -> a.pos));
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            grass.add(new Grass(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        ArrayList<Integer> Ncow = new ArrayList<>();
        for(int i = 0; i < m ; i++){
            Ncow.add(Integer.parseInt(br.readLine()));
        }
        br.close();

        Collections.sort(Ncow);

        ArrayList<Long> Jcow = new ArrayList<>();


        int first = Ncow.get(0);
        Set<Grass> set1 = grass.headSet(new Grass(first));
        if (!set1.isEmpty())
            Jcow.add(sum(set1));
        int last = Ncow.get(m-1);
        Set<Grass> set2 = grass.tailSet(new Grass(last));
        if (!set2.isEmpty())
            Jcow.add(sum(set2));

        for(int i = 0; i < m-1; i++){
            int left = Ncow.get(i);
            int right = Ncow.get(i+1);

            Set<Grass> set = grass.subSet(new Grass(left), new Grass(right));
            ArrayList<Grass> list = new ArrayList<>();
            long max = 0;
            long count =0 ;

            for(Grass g : set){
                int pos = g.pos;
                if (pos-left < right - pos){
                    list.add(new Grass(left, g.val));
                    list.add(new Grass(pos + pos-left, -g.val));
                }else{
                    list.add(new Grass(right, -g.val));
                    list.add(new Grass(pos - right + pos, g.val));
                }
            }

            Collections.sort(list, (a, b) -> a.pos == b.pos ? a.val - b.val : a.pos-b.pos);

            for(Grass g : list){
                count += g.val;
                max = Math.max(max, count);
            }

            long total = sum(set);
            Jcow.add(max);
            Jcow.add(total - max);
        }

        Collections.sort(Jcow, Comparator.comparingLong(a -> -a));
        long ans = 0;
        for(int i = 0; i < n; i++){
            ans += Jcow.get(i);
        }
        pw.println(ans);
        pw.close();
    }

    public static long sum(Set<Grass> set){
        long sum = 0;
        for(Grass g : set){
            sum += g.val;
        }
        return sum;
    }
}
