/*
ID: weq51171
LANG: JAVA
TASK: transform
 */


//package USACO_Training;

import java.io.*;
import java.util.Arrays;

public class transform {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("transform.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));

        int n = Integer.parseInt(br.readLine());
        char[][] before = new char[n][n];
        char[][] after = new char[n][n];

        for (int i = 0; i < n; i++)
            before[i] = br.readLine().toCharArray();

        for (int i = 0; i < n; i++)
            after[i] = br.readLine().toCharArray();


        if(is1(before, after) == false){
            pw.println("1");
            pw.close();
        } else if (is2(before, after) == false){
            pw.println("2");
            pw.close();
        } else if (is3(before, after) == false){
            pw.println("3");
            pw.close();
        } else if (is4(before, after) == false){
            pw.println("4");
            pw.close();
        } else if (is5(before, after) == false){
            pw.println("5");
            pw.close();
        } else if (is6(before, after) == false){
            pw.println("6");
            pw.close();
        } else{
            pw.println("7");
            pw.close();
        }
    }

    public static boolean is1(char[][] before, char[][] after) {
        int n = before.length;
        boolean quit = false;
        for (int i = 0; i < n; i++) {//1
            for (int j = 0; j < n; j++) {
                if (before[i][j] == after[j][n - 1 - i])
                    ;
                else {
                    quit = true;
                    break;
                }
            }
            if (quit)
                break;
        }
        return quit;
    }

    public static boolean is2(char[][] before, char[][] after) {
        boolean quit = false;
        int n = before.length;
        for (int i = 0; i < n; i++) {//2
            for (int j = 0; j < n; j++) {
                if (before[i][j] == after[n - 1 - i][n - 1 - j])
                    ;
                else {
                    quit = true;
                    break;
                }
            }
            if (quit)
                break;
        }
        return quit;
    }

    public static boolean is3(char[][] before, char[][] after) {
        boolean quit = false;
        int n  = before.length;
        for (int i = 0; i < n; i++) {//3
            for (int j = 0; j < n; j++) {
                if (before[i][j] == after[n - 1 - j][i])
                    ;
                else {
                    quit = true;
                    break;
                }
            }
            if (quit)
                break;
        }
        return quit;
    }

    public static boolean is4(char[][] before, char[][] after) {
        boolean quit = false;
        int n  = before.length;
        for (int i = 0; i < n; i++) {//4
            for (int j = 0; j < n; j++) {
                if (before[i][j] == after[i][n-1-j])
                    ;
                else {
                    quit = true;
                    break;
                }
            }
            if (quit)
                break;
        }
        return quit;
    }

    public static boolean is5(char[][] before, char[][] after) {
        char[][] a = new char[before.length][before.length];
        char[][] b = new char[before.length][before.length];
        int n = before.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = before[i][j];
                b[i][j] = after[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                char t = a[i][j];
                a[i][j] = a[i][n-1-j];
                a[i][n-1-j] = t;
            }
        }

        if (is1(a, b) == false)
            return false;
        if (is2(a, b) == false)
            return false;
        if (is3(a, b) == false)
            return false;

        return true;
    }

    public static boolean is6(char[][] before, char[][] after) {
        boolean quit = false;
        int n  = before.length;
        for (int i = 0; i < n; i++) {//6
            for (int j = 0; j < n; j++) {
                if (before[i][j] == after[i][j])
                    ;
                else {
                    quit = true;
                    break;
                }
            }
            if (quit)
                break;
        }
        return quit;
    }

}

