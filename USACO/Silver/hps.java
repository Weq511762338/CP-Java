//package Silver;

import java.io.*;

public class hps {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("hps.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("hps.out"));

        int n = Integer.parseInt(br.readLine());
        int[] h = new int[n+1];
        int[] p = new int[n+1];
        int[] s = new int[n+1];

        for(int i=1;  i <= n ; i++){
            String str = br.readLine();
            p[i] = p[i-1];
            h[i] = h[i-1];
            s[i] = s[i-1];
            if (str.equals("P")) p[i] = p[i-1] + 1;
            if (str.equals("H")) h[i] = h[i-1] + 1;
            if (str.equals("S")) s[i] = s[i-1] + 1;
        }
        br.close();

        int ans = 0;
        for(int i = 1 ; i <= n ; i++){
            int hbefore = h[i] - h[0];
            int hafter = h[n] - h[i];
            int sbefore = s[i] - s[0];
            int safter = s[n] - s[i];
            int pbefore = p[i] - p[0];
            int pafter = p[n] - p[i];
            ans = Math.max(ans, max(hbefore + hafter, hbefore + safter, hbefore + pafter,
                                    sbefore + safter, sbefore + hafter, sbefore + pafter,
                                    pbefore + pafter, pbefore + safter, pbefore + hafter));
        }

        pw.println(ans);
        pw.close();
    }

    public static int max(int ... a){
        int res = 0;
        for(int i  : a){
            res = Math.max(res, i);
        }
        return res;
    }
}
