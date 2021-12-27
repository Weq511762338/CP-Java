//package Silver;

import java.util.*;
import java.io.*;

public class measurement {

    static class Log{
        int day;
        int cow;
        int amount;
        public Log(int d, int c, int a){
            day = d;
            cow = c;
            amount = a;
        }
    }
    public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
//         PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int ans = 0;
        ArrayList<Log> list = new ArrayList<>();
        HashMap<Integer, Integer> cow = new HashMap<>();
        for(int i = 0; i < n ;i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            list.add(new Log(d, c, a));
            cow.put(c, g);
        }
        br.close();
        Collections.sort(list, (a, b)->a.day - b.day);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(g, 1000000000);
        int max = g;

        for(Log log : list){
            int curID = log.cow;
            int incre = log.amount;
            int before = cow.get(curID);
            int maxsize = map.get(max);
            update(map, before, -1);
            update(map, before+incre, 1);
            cow.put(curID, before + incre);

            if (map.get(max) == 0 && (before + incre > max || (before + incre == map.lowerKey(max) && map.get(before+incre) == 1))) ;
            else if(map.get(max) != maxsize || map.lastKey() != max || map.get(max) == 0){
                ans++;
            }

            if(map.get(before) == 0) {
                map.remove(before);
            }
            max = map.lastKey();
        }
        pw.println(ans);
        pw.close();
    }
    public static void update(TreeMap<Integer, Integer> map, int key, int changeVal){
        if(!map.containsKey(key)) map.put(key, 0);
        map.put(key, map.get(key)+changeVal);
    }
}
