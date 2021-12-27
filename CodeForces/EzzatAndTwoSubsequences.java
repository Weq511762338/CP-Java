package CodeForces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EzzatAndTwoSubsequences {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long total = 0;
            int[] arr = new int[n];
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                total += num;
                arr[j] = num;
                max = Math.max(max, num);
            }

            sb.append((max + (double) (total-max)/(n-1)) + System.lineSeparator());

        }
        br.close();
        System.out.println(sb);
    }
}
