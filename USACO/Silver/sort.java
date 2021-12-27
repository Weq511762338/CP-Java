//package Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class sort {
    static class Number{
        int value;
        int index;

        public Number(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("sort.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Number> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new Number(Integer.parseInt(br.readLine()), i));
        }
        br.close();
        Collections.sort(list, (a, b)->(a.value < b.value ? -1 : a.value == b.value ? a.index < b.index ? -1 : 1 : 1));
        int max = 0;
        for(int i = 0 ; i < n; i++){
            max = Math.max(max, list.get(i).index-i);
        }
        pw.println(max+1);
        pw.close();
    }

}
