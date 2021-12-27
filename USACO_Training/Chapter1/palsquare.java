/*
ID: weq51171
LANG: JAVA
TASK: palsquare
 */


//package USACO_Training;

import java.io.*;
import java.util.ArrayList;

public class palsquare {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));

        int base = Integer.parseInt(br.readLine());
        br.close();

        ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 1; i <= 300; i++) {
                ArrayList<String> result = convert(i, base);
                ArrayList<String> squared = convert(pow(i, 2), base);

                boolean isValid = false;
                for (int j = 0; j <= squared.size() / 2; j++) {
                    if (squared.get(j).equals(squared.get(squared.size() - 1 - j)))
                        isValid = true;
                    else {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    for (String s : result) pw.print(s);
                    pw.print(" ");
                    for (String s : squared) pw.print(s);
                    pw.println();
                }
            }
            pw.close();
    }

    public static ArrayList<String> convert(int num, int base){
            int highest = 0;
            for (; pow(base, highest) <= num; highest++) ;
            highest--;
            ArrayList<String> list = new ArrayList<>();
            while (highest >= 0) {
                if (num / pow(base, highest) >= 10) {
                    switch (num / pow(base, highest)) {
                        case 10:
                            list.add("A");
                            break;
                        case 11:
                            list.add("B");
                            break;
                        case 12:
                            list.add("C");
                            break;
                        case 13:
                            list.add("D");
                            break;
                        case 14:
                            list.add("E");
                            break;
                        case 15:
                            list.add("F");
                            break;
                        case 16:
                            list.add("G");
                            break;
                        case 17:
                            list.add("H");
                            break;
                        case 18:
                            list.add("I");
                            break;
                        case 19:
                            list.add("J");
                            break;
                    }
                } else {
                    list.add(String.valueOf(num / pow(base, highest)));
                }
                num = num % pow(base, highest);
                highest--;
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
