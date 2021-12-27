/*
ID: weq51171
LANG: JAVA
TASK: sprime
 */

//package USACO_Training.Chapter1;

import java.io.*;
import java.util.ArrayList;

public class sprime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sprime.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));

        int n = Integer.parseInt(br.readLine());
        br.close();

        /*
        first num is prime
        then all the other number, try adding them with odd number
         */
        ArrayList<Integer> sPrime = new ArrayList<>();
        genSPrime(2, n, sPrime);
        genSPrime(3, n, sPrime);
        genSPrime(5, n, sPrime);
        genSPrime(7, n, sPrime);

        for (int i : sPrime)
            pw.println(i);
        pw.close();
    }

    public static void genSPrime(int startNum, int n, ArrayList<Integer> sPrime){
        if (isPrime(startNum) == false)
            return;
        if (n == 1){
            if (isPrime(startNum))
                sPrime.add(startNum);
        }else {
            genSPrime(startNum*10+1, n-1, sPrime);
            genSPrime(startNum*10+3, n-1, sPrime);
            genSPrime(startNum*10+7, n-1, sPrime);
            genSPrime(startNum*10+9, n-1, sPrime);
        }
    }

    public static boolean isPrime(int num){
        if (num == 2)
            return true;
        for (int i = 3; i*i < num; i++) {
            if (num%i == 0)
                return false;
        }
        return true;
    }

    public static int powerTen(int exp){
        int result = 1;
        for (int i = 0; i < exp; i++) {
            result *= 10;
        }
        return result;
    }
}
