/*
ID: weq51171
LANG: JAVA
TASK: beads
 */
//package USACO_Training;

import java.util.*;
import java.io.*;
public class beads {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("beads.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();


        int red = 0;
        int blue = 0;
        int max = 0;

        char color = str.charAt(0);
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'w'){
                if (color == 'r')
                    red++;
                else
                    blue++;
            }
            if (str.charAt(i) == 'r' && color == 'r')
                red++;
            else if (str.charAt(i) == 'b' && color == 'b')
                blue++;
            color = str.charAt(i);
            if (red != 0 && blue != 0)
                break;
        }
        if (red == n)
            max = red;
        else if (blue == n)
            max = blue;
        else {
            str = str + str;
            red = 0;
            blue = 0;

            for (int i = 0; i < str.length(); ) {

                color = str.charAt(i);

                while (i < str.length() && str.charAt(i) == 'w')
                    i++;

                if (color == 'r') {
                    for (; i < str.length(); i++) {
                        if (str.charAt(i) == 'r' || str.charAt(i) == 'w')
                            red++;
                        else
                            break;
                    }
                } else if (color == 'b') {
                    for (; i < str.length(); i++) {
                        if (str.charAt(i) == 'b' || str.charAt(i) == 'w')
                            blue++;
                        else
                            break;
                    }
                }
                if(red + blue <= n)
                    max = Math.max(red + blue, max);
                if (color == 'b') {
                        red = 0;
                        for (int j = i - 1; j >= 0; j--) {
                            if (str.charAt(j) == 'w') {
                                red++;
                                blue--;
                            } else
                                break;
                        }
                    }
                    if (color == 'r') {
                        blue = 0;
                        for (int j = i - 1; j >= 0; j--) {
                            if (str.charAt(j) == 'w') {
                                blue++;
                                red--;
                            } else
                                break;
                        }
                    }

            }
        }
        pw.println(max);
        pw.close();
    }
}
