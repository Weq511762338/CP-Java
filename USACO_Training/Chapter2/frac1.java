/*
ID: weq51171
TASK: frac1
LANG: JAVA
 */
//package USACO_Training.Chapter2;


import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class frac1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("frac1.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));

        int n = Integer.parseInt(br.readLine());
        br.close();

        ArrayList<Integer> nume = new ArrayList<>();
        ArrayList<Integer> deno = new ArrayList<>();

        HashSet<Double> val = new HashSet<>();
        for (double i = 1; i <= n; i++) {
            for (double j = 0; j <= i; j++) {
                double num = j/i;
                if (!val.contains(num)) {
                    val.add(num);
                    nume.add((int)j);
                    deno.add((int) i);
                }
            }
        }


        /*
        add 0/1 and 1/1 at last
         */

        for (int i = 0; i < deno.size(); i++) {
            double value = (double) nume.get(i)/deno.get(i);
            for (int j = i-1; j >= 0; j--) {
                if ((double)nume.get(j)/deno.get(j) <= value){
                    deno.add(j+1, deno.remove(i));
                    nume.add(j+1, nume.remove(i));
                    break;
                }
            }
        }

        for (int i = 0; i < deno.size(); i++)
            pw.println(nume.get(i) + "/" + deno.get(i));
        pw.close();


    }
}
