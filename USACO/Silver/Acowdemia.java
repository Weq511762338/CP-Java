//package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Acowdemia {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) list.add(Integer.parseInt(st.nextToken()));
        br.close();
        Collections.sort(list, (a, b) -> b-a);

        int left = 1;
        int right = n;
        while (left < right){
            int mid = (left + right + 1)/2;
            if (valid(mid, list, k , l)) left = mid;
            else right = mid -1;
        }

        System.out.println(left);
    }
    public static boolean valid(int h, ArrayList<Integer> list, int k , int l){
        long total = (long) k *l;
        for(int i = 0; i < h; i++){
            if (list.get(i) < h ){
                if (h - list.get(i) <= k && h - list.get(i) <= total)
                    total -= h - list.get(i);
                else
                    return false;
            }
        }
        return true;
    }
}
