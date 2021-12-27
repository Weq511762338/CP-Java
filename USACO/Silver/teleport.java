//package Silver;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class teleport {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br= new BufferedReader(new FileReader("teleport.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));

        int n = Integer.parseInt(br.readLine());
        int slope = 0;
        long ans = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());

            ans += Math.abs(a-b);
            if (Math.abs(a-b) < Math.abs(a)) continue;
            put(map, b, 2);
            if ((a < 0 && b > a) || (a >= 0 && b <= a)) {
                put(map, 0, -1);
                put(map, 2*b, -1);
            }
            if ((a < 0 && b < a) || (a >= 0 && b >= a)){
                put(map, 2*a, -1);
                put(map, 2*b-2*a, -1);
            }
        }
        br.close();
        int curY = 0;
        long minAns = ans;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int newY = entry.getKey();
            ans += (long) (newY - curY) *slope;
            curY = newY;
            slope += entry.getValue();
            minAns = Math.min(minAns, ans);
        }
        pw.println(minAns);
        pw.close();
    }
    public static void put(TreeMap<Integer, Integer> map, int a, int b){
        if (!map.containsKey(a)) map.put(a, b);
        else map.put(a, map.get(a)+b);
    }
}
