//package Silver;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class pairup {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("pairup.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("pairup.out"));
        int n= Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a  = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.put(b, a);
        }
        br.close();

        int ans = 0;
        while(!map.isEmpty()){
            Map.Entry<Integer, Integer> small = map.pollFirstEntry();
            Map.Entry<Integer, Integer> large;
            if (map.isEmpty()) large = small;
            else  large = map.pollLastEntry();

            int num = Math.min(small.getValue(), large.getValue());
            ans = Math.max(ans, small.getKey() + large.getKey());
            if (small.getValue()-num != 0) map.put(small.getKey(), small.getValue()-num);
            if (large.getValue()-num != 0) map.put(large.getKey(), large.getValue()-num);
        }

        pw.println(ans);
        pw.close();
    }
}
