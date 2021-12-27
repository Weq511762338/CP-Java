/*
ID: weq51171
LANG: JAVA
TASK: pprime
 */

//package USACO_Training.Chapter1;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class pprime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("pprime.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());// 1,000,000,000
        br.close();


        ArrayList<Integer> pal = new ArrayList<>();
        if (a <= 11) {
            if (a == 5) {
                pal.add(5);
                pal.add(7);
            } else if (a <= 7)
                pal.add(7);
            pal.add(11);
        }
        pal.addAll(genOddEven(10, 99, a, b, 2));
        pal.addAll(genOddEven(100, 999, a, b, 3));
        pal.addAll(genOddEven(1000, 9999, a, b, 4));

        /*
        generate pal with range and reverse each into odd and even
        while if one is prime, put it in the list
         */

        for (int i = 0; i < pal.size(); i++) {
            pw.println(pal.get(i));
        }
        pw.close();


    }

    //Every prime number can be represented in form of 6n+1 or 6n-1 except the prime number 2 and 3, where n is a natural number.
    public static boolean isPrime(int num){
        if (num == 2)
            return true;
        if (num%2 == 0)
            return false;

        for (int i = 3; i*i <= num; i+=2) {
            if (num%i == 0)
                return false;
        }
        return true;
    }

    public static ArrayList<Integer> genOddEven(int min, int max, int a, int b, int digit){
        ArrayList<Integer> pal = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            int num = i;
            //odd
            int t = i;
            num *= powerTen(digit-1);
            for (int j = 0; j < digit-1; j++) {
                num += t/powerTen(digit-1-j) * powerTen(j);
                t = t%powerTen(digit-1-j);
            }
            if (isPrime(num) && num >= a && num <= b)
                pal.add(num);
            //even
            num = i;
            t = i;
            num *= powerTen(digit);
            for (int j = 0; j < digit; j++) {
                num += t/powerTen(digit-1-j) * powerTen(j);
                t = t%powerTen(digit-1-j);
            }
            if (isPrime(num) && num >= a && num <= b)
                pal.add(num);
        }
        return pal;
    }

    public static int powerTen(int exp){
        int result = 1;
        for (int i = 0; i < exp; i++) {
            result *= 10;
        }
        return result;
    }
}
