package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class cherry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] ans = new long[t];
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());


            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                arr[j] = a;
            }
            for (int left = 0; left < n; left++) {
                int min = arr[left];
                int max = arr[left];
                for (int right = left+1; right < n; right++) {
                    max = Math.max(arr[right], max);
                    min = Math.min(arr[right], min);
                    long res = (long) min *max;
                    ans[i] = Math.max(res, ans[i]);
                }

            }
        }
        br.close();

        for (int i = 0; i < t; i++) {
            System.out.println(ans[i]);
        }
    }
}
