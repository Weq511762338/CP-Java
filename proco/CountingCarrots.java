import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CountingCarrots {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        br.close();

        String a = s.substring(0, s.indexOf(" "));
        String b = s.substring(s.indexOf(" ")+1);

        int numa = 0;
        int product = 1;
        for(int i = a.length()-1;  i >= 0; i--){
            numa += product * Integer.parseInt(String.valueOf(a.charAt(i)));
            product *= k;
        }

        int numb = 0;
        product = 1;
        for(int i = b.length()-1;  i >= 0; i--){
            numb += product * Integer.parseInt(String.valueOf(b.charAt(i)));
            product *= m;
        }

        pw.println((numa - numb));
        pw.close();
    }
}
