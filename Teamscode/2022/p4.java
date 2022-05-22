import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class p4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        long sum = 0;
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            sum += num[i];
        }
        br.close();
        HashSet<Integer> visited = new HashSet<>();
        long[] ans = new long[n];
        for(int i = 0; i < n; i++) {
            if(ans[i] != 0) continue;
            if (findGCD(n, i+1) == 1){
                ans[i] = sum;
                if (i == 0) continue;
                int index = i+1;
                while(index <= n) {
                    ans[index-1] = sum;
                    index += i+1;
                }
            }
            else {
                visited.clear();
                int cur = 0;
                long res = 0;
                while(!visited.contains(cur)){
                    res += num[cur];
                    visited.add(cur);
                    cur = (cur + i+1)%n;
                }
                int index = i+1;
                while(index <= n) {
                    ans[index-1] = res;
                    index += i+1;
                }
            }
        }
        for(long i: ans) pw.println(i);
        pw.close();
    }
    public static int findGCD(int number1, int number2) {
         if(number2 == 0) return number1;
         return findGCD(number2, number1%number2);
    }
}