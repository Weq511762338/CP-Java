//package Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class convention {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("convention.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) list.add(Integer.parseInt(st.nextToken()));
        Collections.sort(list);
        br.close();

        int l = 0;
        int r = list.get(n-1);

        while(l < r){
            int mid = (l+r)/2;

            if (valid(mid, list, n, m, c)) r = mid;
            else l = mid +1;
        }
        pw.println(r);
        pw.close();
    }

    public static boolean valid(int max, ArrayList<Integer> list, int n, int m, int c){
        int last = list.get(0);
        int onbus = 1;
        int count = 1;
        for(int i = 1; i < n; i++){
            if (onbus == c || list.get(i)-last > max){
                last = list.get(i);
                onbus = 1;
                count++;
            }else onbus++;
        }
        return count <= m;
    }
}
