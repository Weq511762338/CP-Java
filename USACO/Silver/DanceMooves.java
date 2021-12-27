//package Silver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
public class DanceMooves {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] line = new int[n+1];
        HashSet<Integer>[] beenTo = new HashSet[n+1];
        for(int i = 1; i <= n; i++) {
            beenTo[i] = new HashSet<>();
            beenTo[i].add(i);
            line[i] = i;
        }

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            beenTo[line[a]].add(b);
            beenTo[line[b]].add(a);
            int t = line[a];
            line[a] = line[b];
            line[b] = t;
        }
        br.close();
        int[] ans = new int[n+1];
        for(int i = 1; i <= n; i++){
            if (ans[i] != 0) continue;
            HashSet<Integer> visited = new HashSet<>();
            HashSet<Integer> cycle = new HashSet<>();
            cycle.add(i);
            visited.addAll(beenTo[i]);
            int cur = i;
            while(!cycle.contains(line[cur])){
                visited.addAll(beenTo[line[cur]]);
                cycle.add(line[cur]);
                cur = line[cur];
            }
            /*for(int a : cycle){
                visited.addAll(beenTo[a]);
            }*/
            for(int a : cycle)
                ans[a] = visited.size();
            //calculate use the visited set to keep track of when to stop the while looop
            //every new pos is arrived, add the beento[pos] to every set in the ma
        }

        for(int i = 1; i<= n; i++) pw.println(ans[i]);
        pw.close();
    }
}
