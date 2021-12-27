package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Moamenandksubarrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        loop : for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            int count = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                arr[j] = Integer.parseInt(st.nextToken());

            for (int j = 0; j < n-1; j++) {
                if (j == n-2 && arr[j] > arr[j+1])
                    count++;
                if (j == 0)
                    count++;
                else if (arr[j] > arr[j+1] && arr[j] < arr[j-1])
                    count++;
                else if (arr[j+1] >= arr[j] && arr[j-1] > arr[j])
                    count++;
                if (count > k){
                    sb.append("No" + "\n");
                    continue loop;
                }
            }
            sb.append("Yes" + "\n");
        }

        br.close();
        System.out.println(sb);
    }
}
