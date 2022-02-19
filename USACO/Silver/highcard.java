//package Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class highcard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("highcard.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        br.close();
        HashSet<Integer> elssie = new HashSet<>(list);
        TreeSet<Integer> bessie = new TreeSet<>();
        for(int i = 1; i <= 2*n; i++){
            if (!elssie.contains(i)) bessie.add(i);
        }

        int ans = 0;
        for(int i : list){
            if (bessie.higher(i) != null){
                ans++;
                bessie.remove(bessie.higher(i));
            }else bessie.pollFirst();
        }

        pw.println(ans);
        pw.close();
    }
}
