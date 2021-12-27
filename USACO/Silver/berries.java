//package Silver;

import java.io.*;
import java.util.*;

public class berries {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("berries.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("berries.out")));

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Integer> tree = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int maxB = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            tree.add(num);
            maxB = Math.max(maxB, num);
        }
        br.close();
        int ans = 0;
        for (int i = 1; i <= maxB; i++) {
            int count = 0;
            for (int j = 0; j< n; j++) count += tree.get(j)/i;

            if (count >= k){
                ans = Math.max(ans, i*(k/2));
                continue;
            }
            int mod = i;
            Collections.sort(tree, (a, b) -> b%mod - a%mod);
            int cur = i*(count - k/2);
            for (int j = 0; j < n && j + count < k; j++) {
                cur += tree.get(j)%i;
            }
            ans = Math.max(ans, cur);
        }
        pw.println(ans);
        pw.close();

    }
}
