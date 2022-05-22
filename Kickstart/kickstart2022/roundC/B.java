package Kickstart.kickstart2022.roundC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int sum = (n+1)*n/2;
            boolean pos = sum%(x+y) == 0;

            pw.println("Case #" + i + ": " + (pos ? "POSSIBLE" : "IMPOSSIBLE"));
            ArrayList<Integer> list = new ArrayList<>();
            if(pos){
                int target = sum/(x+y)*x;
                for(int j = n; j >= 1; j--){
                    if(j >= target){
                        list.add(target);
                        break;
                    }
                    list.add(j);
                    target -= j;
                }
                pw.println(list.size());;
                for(int j = 0; j < list.size()-1; j++){
                    pw.print(list.get(j) + " ");
                }
                pw.println(list.get(list.size()-1));
            }
        }
        br.close();
        pw.close();
    }
}
