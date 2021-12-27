//package Silver;

import java.io.*;

public class MooBuzz {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("moobuzz.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        br.close();

        long num = n/8* 15L-1;
        int carry = n%8;

        switch (carry){
            case 0 : pw.println(num); break;
            case 1 : pw.println(num+2); break;
            case 2 : pw.println(num+3); break;
            case 3 : pw.println(num+5); break;
            case 4 : pw.println(num+8); break;
            case 5 : pw.println(num+9); break;
            case 6 : pw.println(num+12); break;
            case 7 : pw.println(num+14); break;
        }
        pw.close();
    }
}
