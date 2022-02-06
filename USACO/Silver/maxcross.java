//package Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class maxcross {
    static int n;
    static int k;
    static int b;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("maxcross.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("maxcross.out"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        for(int i= 0; i < b ; i++){
            int a = Integer.parseInt(br.readLine());
            arr[a] = 1;
        }
        br.close();
        for(int i = 1; i <= n; i++){
            if (arr[i] == 0) arr[i] = 1;
            else if (arr[i] == 1) arr[i] = 0;

            arr[i] += arr[i-1];
        }

        int l = 0;
        int r = b;
        while(l < r){
            int mid = (l+r)/2;
            if (test(mid)) r = mid;
            else l = mid+1;
        }

        pw.println(r);
        pw.close();
    }

    public static boolean test(int num){
        for(int i = 0; i <= n-k; i++){
            if (arr[i+k]-arr[i] + num >= k) return true;
        }
        return false;
    }
}
