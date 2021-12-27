//package Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class cereal {
    static class Cow{
        int f;
        int s;
        public Cow(int f, int s) {
            this.f = f;
            this.s = s;
        }

    }
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);

        BufferedReader br = new BufferedReader(new FileReader("cereal.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cereal.out")));


        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Cow> list = new ArrayList<>();
        int[] index = new int[m+1];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int fav = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());
            Cow c = new Cow(fav, sec);
            list.add(c);
        }
        br.close();

        ArrayList<Integer> ans = new ArrayList<>();

        int cur = 0;
        for(int i = n-1; i >= 0; i--){
            int j = i;
            int toadd = list.get(j).f;
            while(true){
                if (index[toadd] == 0){
                    index[toadd] = j;
                    cur++;
                    break;
                }
                if (index[toadd] < j) break;
                int temp = index[toadd];
                index[toadd] = j;
                if (toadd == list.get(temp).f){
                    j = temp;
                    toadd = list.get(temp).s;
                }else break;
            }
            ans.add(cur);
        }

        for(int i = n-1; i >= 0; i--) pw.println(ans.get(i));
        pw.close();
    }
}
