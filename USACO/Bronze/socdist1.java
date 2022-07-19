package Bronze;

import java.io.*;

public class socdist1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        PrintWriter pw = new PrintWriter(System.out);
//        BufferedReader br = new BufferedReader(new FileReader("socdist1.in"));
//        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("socdist1.out")));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        br.close();
        int min = n+10;
        int fir = 0, sec = 0;
        int cnt = 0;
        int cnt1 = 0;
        boolean firOne = false;
        boolean secOne = false;
        for(int i = 0; i < n; i++){
            if(str.charAt(i) == '0')
                cnt ++;
            else{
                if(cnt1 != 0)
                    min = Math.min(cnt, min);
                if(cnt >= fir) {
                    sec = fir;
                    secOne = firOne;
                    fir = cnt;
                    firOne = false;
                    if (cnt1 == 0)
                        firOne = true;
                }
                cnt1++;
                cnt = 0;
            }
        }
        if(cnt >= fir) {
            sec = fir;
            secOne = firOne;
            fir = cnt;
            firOne = true;
        }
        if(cnt1 == 0){
            pw.println(n-1);
        }else{
            int a, b;
            if(firOne) a = fir;
            else a = (fir+1)/2;
            if(secOne) b = sec;
            else b = (sec+1)/2;

            int c;
            if(firOne) c = (fir-1+1)/2;
            else c = Math.min((fir-2)/3+1, (fir-2*((fir-2)/3+1))+1);

            pw.println(Math.min(min+1, Math.max(c, Math.min(a, b))));
        }
        pw.close();

    }
}
