//package Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class citystate {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("citystate.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("citystate.out"));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, HashMap<String, Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String city = st.nextToken().substring(0, 2);
            String state = st.nextToken();
            if (!map.containsKey(state))
                map.put(state, new HashMap<>());
            if (!map.get(state).containsKey(city))
                map.get(state).put(city, 0);
            map.get(state).put(city, map.get(state).get(city)+1);
        }
        br.close();
        int ans = 0;

        for(Map.Entry<String, HashMap<String, Integer>> entry : map.entrySet()){
            String state = entry.getKey();
            for(Map.Entry<String, Integer> e : entry.getValue().entrySet()){
                String city = e.getKey();
                if (map.containsKey(city) && !city.equals(state) && map.get(city).containsKey(state)) {
                    ans += map.get(city).get(state)*e.getValue();
                }
            }
        }
        pw.println(ans/2);
        pw.close();
    }
}
