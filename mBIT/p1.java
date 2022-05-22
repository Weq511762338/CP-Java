import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class p1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        HashSet<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        int time = -1;
        for(int i = 0; i < q; i++){
            int num = Integer.parseInt(st.nextToken());
            if(!set.contains(num)) set.add(num);
            else set.remove(num);
            if (set.size() == n){
                time = i+1;
                break;
            }
        }
        br.close();
        pw.println(time);
        pw.close();

    }

}
