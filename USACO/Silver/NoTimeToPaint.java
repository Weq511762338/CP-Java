//package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class NoTimeToPaint {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        String str = br.readLine();

        int[] froml = new int[n+1];
        int[] fromr = new int[n+2];

        Stack<Character> paint = new Stack<>();
        int count = 0;
        for(int i = 0; i < n; i++){
            char c = str.charAt(i);
            if (paint.isEmpty()){
                paint.add(c);
                count++;
            }else if (paint.peek() != c) {
                if (!paint.isEmpty() && paint.peek() < c)
                    count++;
                if (!paint.isEmpty() && paint.peek() > c) {
                    while (!paint.isEmpty() && paint.peek() > c)
                        paint.pop();
                    if (paint.isEmpty() || paint.peek() < c) count++;
                }
                paint.add(c);
            }
            froml[i+1] = count;
        }

        count = 0;
        paint.clear();
        for(int i = n-1; i >= 0; i--){
            char c = str.charAt(i);
            if (paint.isEmpty()){
                paint.add(c);
                count++;
            }else if (paint.peek() != c) {
                if (!paint.isEmpty() && paint.peek() < c)
                    count++;
                if (!paint.isEmpty() && paint.peek() > c) {
                    while (!paint.isEmpty() && paint.peek() > c)
                        paint.pop();
                    if (paint.isEmpty() || paint.peek() < c) count++;
                }
                paint.add(c);
            }
            fromr[i+1] = count;
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pw.println((froml[a-1] + fromr[b+1]));
        }
        pw.close();
        br.close();
    }
}
