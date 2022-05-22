//package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class COWOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String str = br.readLine();
        int q = Integer.parseInt(br.readLine());
        int[] c = new int[str.length()+1];
        int[] o = new int[str.length()+1];
        int[] w = new int[str.length()+1];
        for(int i=1;i<=str.length();i++) {
            c[i] = c[i-1];
            o[i] = o[i-1];
            w[i] = w[i-1];

            if (str.charAt(i-1) == 'C') {
                c[i] = c[i-1] + 1;
            }
            else if (str.charAt(i-1) == 'O') {
                o[i] = o[i-1] + 1;
            }
            else {
                w[i] = w[i-1] + 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<q;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int numC = c[r] - c[l-1];
            int numO = o[r] - o[l-1];
            int numW = w[r] - w[l-1];
            if ((numC %2 == 0 && numO %2 == 1 && numW %2 == 1) || (numC %2 == 1 && numO %2 == 0 && numW %2 == 0)) {
                sb.append("Y");
            }else
                sb.append("N");
        }
        br.close();
        pw.println(sb);
        pw.close();
    }
}
