package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class JuryMeeting {
    final static int MOD = 998244353;

    public static long qpow(long base, long exp){
        long result = 1;

        while(exp > 0){
            if ((exp&1) == 1) result = result*base%MOD;
            base = base*base%MOD;
            exp >>= 1;
        }
        return  result%MOD;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw =new PrintWriter(System.out);

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            //total permutaions - not nice permutations
            //it is not going to be nice only when the largest (only one largest) is after all the other second largest

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] tasks = new int[n];
            int max = 0;
            int maxCount = 0;
            for (int j = 0; j <n; j++) {
                int num = Integer.parseInt(st.nextToken());
                tasks[j] = num;
                if (num > max){
                    max = num;
                    maxCount = 1;
                }else if (num == max){
                    maxCount ++;
                }
            }
            int secCount = 0;
            for (int j = 0; j <n; j++) {
                int num = tasks[j];
                if (num == max - 1)
                    secCount ++;
            }
            long ans = 1;
            long sub  =1;

            for(int j = 1; j <= n ;j++){
                ans =  ans * j %MOD;
                if (j != secCount + 1) sub = sub *j%MOD;
            }
            if (maxCount > 1) sb.append(ans + "\n");
//            else sb.append((ans - sub + MOD)%MOD + "\n");
            else sb.append((ans - ans*qpow(secCount+1, MOD-2)%MOD + MOD)%MOD + "\n");
        }
        br.close();
        pw.print(sb);
        pw.close();
    }
}
