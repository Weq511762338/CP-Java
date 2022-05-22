/*
ID: weq51171
TASK: hamming
LANG: JAVA
 */

//package Chapter2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class hamming {

    static int n;
    static int bits;
    static int dis;
    static TreeSet<Integer>[] set;
    static ArrayList<Integer> list;
    static boolean done;
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br=  new BufferedReader(new FileReader("hamming.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        bits = Integer.parseInt(st.nextToken());
        dis = Integer.parseInt(st.nextToken());
        br.close();

        set = new TreeSet[(1 << bits)+1];
        list = new ArrayList<>();
        for(int i = 0; i <= (1 << bits); i++) {
            TreeSet<Integer> temp = new TreeSet<>();
            for(int j = i+1; j <= (1 << bits); j++){
                int dif = 0;
                for(int a = 0; a <= bits; a ++){
                    if (((i >> a) & 1) != ((j >> a) & 1)){
                        dif++;
                    }
                }
                if (dif >= dis) temp.add(j);
            }
            set[i] = temp;
        }

        list.add(0);
        rec(0, new TreeSet<>(set[0]));

        for(int i = 1; i <= list.size(); i++){
            if (i == list.size()) pw.println(list.get(i-1));
            else if (i % 10 == 0) pw.println(list.get(i-1));
            else pw.print(list.get(i-1) + " ");
        }
        pw.close();
    }

    public static void rec(int num, TreeSet<Integer> common){
        if (list.size() >= n) {
            done = true;
            return;
        }
        for(int i : common){
            TreeSet<Integer> temp = new TreeSet<>();
            for(int j : set[i]){
                if (common.contains(j)) temp.add(j);
            }
            list.add(i);
            rec(i, temp);
            if (done) return;
            list.remove(list.size()-1);
        }
    }
}
