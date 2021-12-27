/*
ID: weq51171
LANG: JAVA
TASK: dualpal
 */

//package USACO_Training;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class dualpal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("dualpal.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        br.close();

        int count = 0;
        s++;
        while(count != n){
            int countPal = 0;
            boolean isPal = false;
            boolean valid = false;
            for (int i = 2; i <= 10 ; i++) {
                ArrayList<Integer> result = convert(s, i);
                for (int j = 0; j < result.size(); j++) {
                    if (result.get(j) == result.get(result.size() - 1 - j))
                        isPal = true;
                    else {
                        isPal = false;
                        break;
                    }
                }
                if (isPal)
                    countPal++;
                if (countPal >= 2) {
                    valid = true;
                    break;
                }
            }
            if (valid) {
                pw.println(s);
                count++;
            }
            s++;
        }
        pw.close();
    }


    public static ArrayList<Integer> convert(int num, int base){
        ArrayList<Integer> list = new ArrayList<>();

        int highest = 0;
        while(pow(base, highest) <= num) highest ++;
        highest --;

        while(highest >= 0){
            list.add(num / pow(base, highest));
            num = num % pow(base, highest);
            highest --;
        }

        return list;
    }


    public static int pow(int base, int exp){
        int result = 1;
        while(exp > 0){
            result *= base;
            exp--;
        }
        return result;
    }
}
