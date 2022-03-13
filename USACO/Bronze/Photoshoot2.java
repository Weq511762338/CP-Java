//package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Photoshoot2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw =new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        int[] now = new int[n];
        int[] res = new int[n];
        StringTokenizer st =new StringTokenizer(br.readLine());

        for(int i= 0; i < n; i++){
            now[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i= 0; i < n ; i++){
            res[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        TreeSet<Integer> set= new TreeSet<>();
        int[] idToPos = new int[n+1];
        for(int  i= 1; i <= n; i++){
            idToPos[now[i-1]] = i-1;
        }

        int count = 0;
        for(int i= 0; i < n ; i++){
            int cow = res[i];
            int pos = idToPos[cow] + set.subSet(idToPos[cow], true, n, true).size();
            if (cow != res[pos]){
                set.add(idToPos[cow]);
                count++;
            }
        }
        pw.println(count);
        pw.close();
    }
}
