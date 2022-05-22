package Kickstart.kickstart2022.roundC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i = 1; i <= t; i++){
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            boolean lower= false;
            boolean upper = false;
            boolean digit= false;
            boolean special = false;
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) >= 97 && str.charAt(j) <= 122) lower = true;
                if(str.charAt(j) >= 65 && str.charAt(j) <= 90) upper = true;
                if(str.charAt(j) >= 48 && str.charAt(j) <= 57) digit = true;
                if(str.charAt(j) == '#' || str.charAt(j) == '@' ||str.charAt(j) == '*' ||str.charAt(j) == '&') special = true;
            }

            if(!lower) str += "a";
            if(!upper) str += "A";
            if(!digit) str += "3";
            if(!special) str += "#";
            while(str.length() < 7){
                str += "3";
            }
            pw.println("Case #" + i + ": " + str);

        }
        br.close();
        pw.close();

    }


}
