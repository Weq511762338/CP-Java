//package Silver;

import java.io.*;
import java.util.*;

public class haybales {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("haybales.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("haybales.out"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < n; i++){
            map.put(list.get(i), i);
        }

        for(int i =0 ; i < q; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Map.Entry<Integer, Integer> right = map.floorEntry(b);
            Map.Entry<Integer, Integer> left = map.floorEntry(a);
            int ans = 0;
            if (right == null);
            else if (left == null){
                ans = right.getValue()+1;
            }else if (left.getKey() == a){
                ans = right.getValue()-left.getValue()+1;
            }else
                ans = right.getValue() - left.getValue();
            pw.println(ans);
        }

        br.close();
        pw.close();
    }
}
