//package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class CowFrisbee {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        int[] arr =  new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        int[] pos = new int[n+1];
        for(int i = 1; i <= n ;i++){
            pos[arr[i]] = i;
        }
        long ans = 0;

        Stack<Integer> stack = new Stack<>();
        for(int i = 1; i <=n; i++){
            while(!stack.isEmpty() && stack.peek() < arr[i]){
                ans += pos[arr[i]] - pos[stack.pop()] + 1;
            }
            if (!stack.isEmpty()) ans += pos[arr[i]] - pos[stack.peek()]+1;
            stack.push(arr[i]);
        }
        pw.println(ans);
        pw.close();
    }
}
