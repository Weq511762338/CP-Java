//package Silver;
import java.util.*;
import java.io.*;
public class reduce {
    static class Cow{
        int x;
        int y;

        public Cow(int a, int b){
            x = a;
            y = b;
        }
    }
    static TreeSet<Cow> listx;
    static TreeSet<Cow> listy;
    static long ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("reduce.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));

        int n =Integer.parseInt(br.readLine());
        listx = new TreeSet<>(Comparator.comparingInt(a-> a.x));
        listy = new TreeSet<>(Comparator.comparingInt(a-> a.y));

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Cow c = new Cow(x, y);
            listx.add(c);
            listy.add(c);
        }
        br.close();
        for(int i = 0; i < 4; i++){
            Cow c1 = rm(i);
            Cow c2;
            Cow c3;
            for(int j = 0; j < 4; j++){
                c2 = rm(j);
                for(int k = 0; k < 4; k++){
                    c3 = rm(k);
                    ans = Math.min(ans, eval());
                    listx.add(c3);
                    listy.add(c3);
                }
                listx.add(c2);
                listy.add(c2);
            }
            listx.add(c1);
            listy.add(c1);
        }

        pw.println(ans);
        pw.close();
    }

    public static long eval(){
        long cur = 0;
        cur = (long)(listx.last().x - listx.first().x)* (listy.last().y - listy.first().y);
        return cur;
    }

    public static Cow rm(int mark){
        Cow c;
        switch(mark){
            case (0):
                c = listx.pollFirst();
                listy.remove(c);
                return c;
            case (1):
                c = listx.pollLast();
                listy.remove(c);
                return c;
            case (2):
                c = listy.pollFirst();
                listx.remove(c);
                return c;
            case (3):
                c = listy.pollLast();
                listx.remove(c);
                return c;
        }
        return null;
    }
}
