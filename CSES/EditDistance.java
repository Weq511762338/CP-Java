package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EditDistance {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String ori = sc.next();
        String aft = sc.next();
        sc.close();

        int[] oriChar = new int[26];
        int[] aftChar = new int[26];

        for (int i = 0; i < ori.length(); i++) {
            oriChar[ori.charAt(i)-65]++;
        }
        for (int i = 0; i < aft.length(); i++) {
            aftChar[aft.charAt(i)-65]++;
        }

        int add = 0;
        int del = 0;

        for (int i = 0; i < oriChar.length; i++) {
            if (aftChar[i] > oriChar[i])
                add += aftChar[i] - oriChar[i];
            if (aftChar[i] < oriChar[i])
                del += oriChar[i] - aftChar[i];
        }

        if (add >= del)
            System.out.println(add);
        else
            System.out.println(del - add);
    }


}
