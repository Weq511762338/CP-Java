package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class interestingStory {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            PriorityQueue<Integer>[] arr = new PriorityQueue[5];
            for(int x = 0; x < 5; x ++)
                arr[x] = new PriorityQueue<>((a, b) -> b-a);
            for (int j = 0; j < n; j++) {
                String str = br.readLine();
                int total = str.length();
                int a = 0;
                int b = 0;
                int c = 0;
                int d = 0;
                int e = 0;
                for (int k = 0; k < str.length(); k++) {
                    switch (str.charAt(k)){
                        case 'a' : a++; break;
                        case 'b' : b++; break;
                        case 'c' : c++; break;
                        case 'd' : d++;break;
                        case 'e' : e++;break;
                    }
                }
                arr[0].add(a-(total-a));
                arr[1].add(b-(total-b));
                arr[2].add(c-(total-c));
                arr[3].add(d-(total-d));
                arr[4].add(e-(total-e));
            }
            int ans = 0;
            for (int j = 0; j < 5; j++) {
                int count = 0;
                int sum = 0;
                while(!arr[j].isEmpty()){
                    int num = arr[j].poll();
                    if (sum + num > 0) {
                        sum += num;
                        count++;
                    }
                    else
                        break;
                }
                ans = Math.max(ans, count);
            }
            sb.append(ans + "\n");
        }
        br.close();
        System.out.println(sb);

    }

}
