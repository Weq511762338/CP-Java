package Silver;

import java.io.*;
import java.util.*;
public class LemonadeLine {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("lemonade.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] m = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int ans = 0;
        Arrays.sort(m);
        for (int i = n-1; i >= 0; i--) {
            if(m[i] < ans)
                break;
            ans++;
        }

        pw.println(ans);
        pw.close();
    }
}
