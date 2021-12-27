package Kickstart;

import java.io.*;
import java.util.StringTokenizer;

public class DogsAndCats {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i =1; i <= t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            String s = br.readLine();
            int numD = 0;
            int numC = 0;
            for(int j = 0 ; j < n; j++){
                char ch = s.charAt(j);
                if (ch == 'D')
                    numD++;
                else if (ch == 'C')
                    numC++;
            }
            for(int j = 0 ; j < n ; j++){
                char ch = s.charAt(j);
                if (ch == 'D'){
                    if (d == 0)
                        break;
                    numD--;
                    d--;
                    c += m;
                }else if (ch == 'C'){
                    if (c == 0)
                        break;
                    numC--;
                    c--;
                }
            }
            sb.append("Case #" + i + ": " + (numD == 0 ? "YES" : "NO") + "\n");
        }
        br.close();
        pw.print(sb);
        pw.close();
    }
}
