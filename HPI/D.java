import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list =new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        br.close();
        Collections.sort(list);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : list){
            if (!map.containsKey(i))
                map.put(i, 0);
            map.put(i, map.get(i)+1);
        }

        for(int i : list){
            if (!map.containsKey(i-1)){
                map.put(i-1, 1);
                map.put(i, map.get(i)-1);
            }else if (map.get(i) == 1) continue;
            else{
                if (!map.containsKey(i+1)) map.put(i+1, 0);
                map.put(i+1, map.get(i+1)+1);
                map.put(i, map.get(i)-1);
            }

            if (map.get(i) == 0) map.remove(i);
        }

        System.out.println(map.size());
    }
}
