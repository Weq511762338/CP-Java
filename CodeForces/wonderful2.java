package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class wonderful2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int color = 0;
            HashMap<Integer, ArrayList<Integer>> map =new HashMap<>();
            st = new StringTokenizer(br.readLine());
            int[] ans = new int[n];
            int total = 0;
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (!map.containsKey(a))
                    map.put(a, new ArrayList<>());
                if (map.get(a).size() < k){
                    map.get(a).add(j);
                    total ++;
                }
            }

            total -= total%k;
            Set<Map.Entry<Integer, ArrayList<Integer>>> set = map.entrySet();
            loop : for(Map.Entry<Integer, ArrayList<Integer>> entry : set){
                for(int num : entry.getValue()){
                    ans[num] = ++color;
                    color %= k;
                    if (--total == 0) break loop;
                }
            }
            for (int j = 0; j < n; j++) {
                sb.append(ans[j] + " ");
            }
            sb.append("\n");
        }
        br.close();

        System.out.println(sb);

    }
}
