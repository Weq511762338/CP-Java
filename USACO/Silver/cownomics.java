//package Silver;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class cownomics {
    static int n;
    static int m;
    static String[] arr;
    static int[] A;
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("cownomics.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
        int ans = 0;
        arr = new String[2*n];
        A = new int[64];

        for(int i= 0; i < 2*n; i++){
            String str = br.readLine();
            arr[i] = str;
        }
        br.close();


        for (int i = 0; i < m; i++) {
            for (int j = i+1; j < m; j++) {
                for (int k = j+1; k < m; k++) {
                    if (test(i, j, k)) ans++;
                }
            }
        }
        pw.println(ans);
        pw.close();
    }

//    public static boolean test(int i , int j, int k){
//        boolean good = true;
//        for(int a = 0; a < n; a++){
//            char c1 = arr[a].charAt(i);
//            char c2 = arr[a].charAt(j);
//            char c3 = arr[a].charAt(k);
//            int num1 = c1 == 'A' ? 0 : c1 == 'C' ? 1 : c1 == 'G' ? 2 : 3;
//            int num2 = c2 == 'A' ? 0 : c2 == 'C' ? 1 : c2 == 'G' ? 2 : 3;
//            int num3 = c3 == 'A' ? 0 : c3 == 'C' ? 1 : c3 == 'G' ? 2 : 3;
//            A[16*num1 + 4*num2 + num3] = 1;
//        }
//        for(int a = n; a < 2*n; a++){
//            char c1 = arr[a].charAt(i);
//            char c2 = arr[a].charAt(j);
//            char c3 = arr[a].charAt(k);
//            int num1 = c1 == 'A' ? 0 : c1 == 'C' ? 1 : c1 == 'G' ? 2 : 3;
//            int num2 = c2 == 'A' ? 0 : c2 == 'C' ? 1 : c2 == 'G' ? 2 : 3;
//            int num3 = c3 == 'A' ? 0 : c3 == 'C' ? 1 : c3 == 'G' ? 2 : 3;
//            if (A[16*num1 + 4*num2 + num3] ==1) good = false;
//        }
//        for(int a = 0; a < n; a++){
//            char c1 = arr[a].charAt(i);
//            char c2 = arr[a].charAt(j);
//            char c3 = arr[a].charAt(k);
//            int num1 = c1 == 'A' ? 0 : c1 == 'C' ? 1 : c1 == 'G' ? 2 : 3;
//            int num2 = c2 == 'A' ? 0 : c2 == 'C' ? 1 : c2 == 'G' ? 2 : 3;
//            int num3 = c3 == 'A' ? 0 : c3 == 'C' ? 1 : c3 == 'G' ? 2 : 3;
//            A[16*num1 + 4*num2 + num3] = 0;
//        }
//        return good;
//    }


    public static boolean test(int i, int j, int k){
        HashSet<String> set1 = new HashSet<>();
        for(int a = 0; a < n; a++){
            set1.add("" + arr[a].charAt(i) + arr[a].charAt(j) + arr[a].charAt(k) + "");
        }
        HashSet<String> set2 = new HashSet<>();
        for(int a = n; a < 2*n; a++){
            set2.add("" + arr[a].charAt(i) + arr[a].charAt(j) + arr[a].charAt(k) + "");
        }
        for(String s : set1){
            if (set2.contains(s)) return false;
        }
        return true;
    }

}
