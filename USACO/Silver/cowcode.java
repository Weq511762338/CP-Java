//package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class cowcode {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowcode.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("cowcode.out"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        long n = Long.parseLong(st.nextToken());
        br.close();
        long total = str.length();
        while(total < n){
            total *=2;
        }
        long ans = n;
        while(ans > str.length()){
            if (ans <= total/2) {
                total /=2;
                continue;
            }
            if ((ans-total/2) == 1) ans = total/2;
            else ans = (ans-total/2)-1;
            total /=2;
        }

        pw.println(str.charAt((int) (ans-1)));
        pw.close();
    }
}
