//package Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class herding {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("herding.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list  = new ArrayList<>();
        for(int i = 0; i < n ; i++) list.add(Integer.parseInt(br.readLine()));
        br.close();
        Collections.sort(list);
        int left = list.get(1) - list.get(0) - 1;
        int right = list.get(n-1) - list.get(n-2) - 1;
        int max = Math.max(list.get(n-2) - list.get(0), list.get(n-1)-list.get(1)) - (n-2);

        int maxCount = 0;
        int j = 0;
        for(int i = 0 ; i < n; i++){
            while(j < n-1 && list.get(j+1) - list.get(i) + 1 <= n) j++;
            maxCount = Math.max(maxCount, j - i + 1);
        }

        if ((left >= 2 && list.get(n-1) - list.get(1) + 1 == n-1) || (right >= 2 && list.get(n-2) - list.get(0) + 1 == n-1))
            maxCount = 2;
        else maxCount = n - maxCount;
        pw.println(maxCount);
        pw.println(max);
        pw.close();
    }
}
