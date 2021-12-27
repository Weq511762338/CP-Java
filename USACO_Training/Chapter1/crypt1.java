/*
ID: weq51171
TASK: crypt1
LANG: JAVA
 */

//package USACO_Training;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class crypt1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("crypt1.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> num = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            num.add(Integer.parseInt(st.nextToken()));
        }
        br.close();

        int count = 0;
        /*

        check valid factor
        then check the partial product
        check the product
         */

                        for (int f1 = 0; f1 < n; f1++) {
                            for (int f2 = 0; f2 < n; f2++) {
                                for (int f3 = 0; f3 < n; f3++) {
                                    int factor1 = num.get(f1)*100 + num.get(f2)*10 + num.get(f3);
                                    for (int f4 = 0; f4 < n; f4++) {
                                        if (num.get(f4)*factor1 >= 1000)
                                            continue;
                                        for (int f5 = 0; f5 < n; f5++) {
                                            if (num.get(f5)*factor1 >= 1000)
                                                continue;
                                            int factor2 = num.get(f4)*10 + num.get(f5);
                                                int tens = num.get(f4);
                                                int ones = num.get(f5);
                                                if (factor1*tens < 1000 && factor1*ones < 1000) {
                                                    if(num.contains((num.get(f3) * ones) % 10) && num.contains((num.get(f2) * ones % 10 + num.get(f3) * ones / 10) %10) &&  num.contains(num.get(f1)*ones + num.get(f2)*ones / 10 + (num.get(f2) * ones % 10 + num.get(f3) * ones / 10)/10)){
                                                        if(num.contains((num.get(f3) * tens) % 10) && num.contains((num.get(f2) * tens % 10 + num.get(f3) * tens / 10) %10) &&  num.contains(num.get(f1)*tens + num.get(f2)*tens / 10 + (num.get(f2) * tens % 10 + num.get(f3) * tens / 10)/10)){
                                                            int product = factor1*factor2;
                                                            if (num.contains(product/1000) && num.contains(product%1000/100) && num.contains(product%1000%100/10) && num.contains(product%1000%100%10))
                                                                count++;
                                                        }
                                                    }
                                                }
                                        }
                                    }
                                }
                            }
        }



        pw.println(count);
        pw.close();
    }
}
