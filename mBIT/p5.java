import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class p5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        int gap = 0;
        int rep = 0;
        StringTokenizer st =new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        int last = Integer.parseInt(st.nextToken());
        if (!map.containsKey(last)) map.put(last, 0);
        map.put(last, map.get(last)+1);
        for(int i = 1 ; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            gap += num - last - 1;
            last = num;
            if (!map.containsKey(num)) map.put(num, 0);
            map.put(num, map.get(num)+1);
        }
        br.close();
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            rep = Math.max(rep, e.getValue());
        }
        pw.println(Math.max(gap, rep-1));
        pw.close();

    }
}