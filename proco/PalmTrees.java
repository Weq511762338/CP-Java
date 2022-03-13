import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PalmTrees {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n  =  Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        int last = 1;
        int ans = 0;
        int end = 0;
        for(int i = 0; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            end = a;
            if (b <= h) continue;
            ans = Math.max(ans, a -1 - last);
            last = a + 1;
        }
        br.close();
        ans = Math.max(ans, end - last);


        pw.println(ans);
        pw.close();
    }
}
