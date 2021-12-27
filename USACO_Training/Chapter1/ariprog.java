/*
ID: weq51171
LANG: JAVA
TASK: ariprog
 */

//package USACO_Training.Chapter1;

import java.io.*;
import java.util.ArrayList;

public class ariprog {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("ariprog.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));

        int n = Integer.parseInt(br.readLine());//n rows
        int m = Integer.parseInt(br.readLine());
        br.close();

        int max = m*m*2;
        boolean[] bisquares = new boolean[max+1];//count 0
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= m; j++) {
                bisquares[i*i+j*j] = true;
            }
        }

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        int b = 1;
        int a = 0;
        while((n-1)*b <= max){
            for (; a <= max; a++) {
                if (a+(n-1)*b > max)
                    break;
                boolean valid = false;
                for (int i = 0; i < n; i++) {
                    if (bisquares[a+b*i])
                        valid = true;
                    else {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    list.add(new ArrayList<>());
                    list.get(list.size()-1).add(a);
                    list.get(list.size()-1).add(b);
                }
            }
            a = 0;
            b++;
        }



        if (list.size() == 0)
            pw.println("NONE");
        else
            for (int i = 0; i < list.size(); i++) {
                pw.println(list.get(i).get(0) + " " + list.get(i).get(1));
            }

        pw.close();

    }

}
