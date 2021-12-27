//package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class ABC {
    static int ans = 0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            ans = 0;
            HashSet<Integer> possible = new HashSet<>();
            for(int a : arr){
                possible.add(a);
                for(int b : arr){
                    if (a < b){
                        possible.add(b-a);
                    }
                }
            }

            for(int a: possible){
                for(int b: possible){
                    for (int c: possible){
                        if (a <= b && b <= c){
                            List<Integer> allNumbers = Arrays.asList(a, b, c, a + b, b + c, c + a, a + b + c);
                            boolean works = true;
                            for (int x : arr) {
                                if (!allNumbers.contains(x)) {
                                    works = false;
                                    break;
                                }
                            }
                            if (works)
                                ans++;
                        }
                    }
                }
            }

            sb.append(ans + "\n");
        }
        br.close();
        PrintWriter pw = new PrintWriter(System.out);
        pw.print(sb);
        pw.close();
    }
}
