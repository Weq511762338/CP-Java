/*
ID: weq51171
LANG: JAVA
TASK: namenum
 */

//package USACO_Training;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class namenum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("namenum.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));

        char[] num = br.readLine().toCharArray();
        br.close();

        ArrayList<String> validName = new ArrayList<>();

        ArrayList<Character>[] key = new ArrayList[9+1];
        key[2] = new ArrayList<Character>();
        key[2].add('A');
        key[2].add('B');
        key[2].add('C');
        key[3] = new ArrayList<Character>();
        key[3].add('D');
        key[3].add('E');
        key[3].add('F');
        key[4] = new ArrayList<Character>();
        key[4].add('G');
        key[4].add('H');
        key[4].add('I');
        key[5] = new ArrayList<Character>();
        key[5].add('J');
        key[5].add('K');
        key[5].add('L');
        key[6] = new ArrayList<Character>();
        key[6].add('M');
        key[6].add('N');
        key[6].add('O');
        key[7] = new ArrayList<Character>();
        key[7].add('P');
        key[7].add('R');
        key[7].add('S');
        key[8] = new ArrayList<Character>();
        key[8].add('T');
        key[8].add('U');
        key[8].add('V');
        key[9] = new ArrayList<Character>();
        key[9].add('W');
        key[9].add('X');
        key[9].add('Y');

        BufferedReader read = new BufferedReader(new FileReader("dict.txt"));
        String str = read.readLine();;
        while(str != null){
            boolean accept = false;
            for (int i = 0; i < num.length; i++) {
                if (key[Integer.parseInt(String.valueOf(num[i]))].contains(str.charAt(i)) && str.length() == num.length)
                    accept = true;
                else{
                    accept = false;
                    break;
                }
            }
            if (accept)
                validName.add(str);
            str = read.readLine();
        }
        if(validName.size() == 0)
            pw.println("NONE");
        else {
            for (int i = 0; i < validName.size(); i++) {
                pw.println(validName.get(i));
            }
        }
        pw.close();
    }

}
