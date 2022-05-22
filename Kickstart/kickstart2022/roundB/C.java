package kickstart2022.roundB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class C {
    static int d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        for(int i = 1; i <= t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            int n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            int last = -1;
            st = new StringTokenizer(br.readLine());

            for(int a  = 0; a < n; a++){
                int num = Integer.parseInt(st.nextToken());
                if (last != num) list.add(num);
                last = num;
            }
            int ans = Integer.MAX_VALUE;
            for(int a = 0; a < list.size(); a++){
                ans = Math.min(help(a, new ArrayList<>(list)), ans);
            }
            pw.println("Case #" + i + ": " + ans);
        }
        br.close();
        pw.close();
    }

    public static int dis(int a, int b){
        int x = Math.abs(a - b);
        int disabot = a;
        int disatop = d-a;
        int disbbot = b;
        int disbtop = d-b;
        int sum1 = disabot + disbbot;
        int sum2 = disabot + disbtop;
        int sum3 = disatop + disbbot;
        int sum4 = disatop + disbtop;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(x);
        list.add(sum1);
        list.add(sum2);
        list.add(sum3);
        list.add(sum4);
        Collections.sort(list);
        return list.get(0);
    }

    public static int help(int start, ArrayList<Integer> list){
        int count = 0;
        int l = start;
        int r = start;
        int cur = list.get(start);
        int left = cur;
        int right = cur;
        while(!(l == 0 && r == list.size()-1)){
            if (l > 0){
                l--;
                left = list.get(l);
            }
            if (r < list.size()-1){
                r++;
                right = list.get(r);
            }
            if (left == cur && right != cur){
                count += dis(cur, right);
                cur = right;
            } else if (left != cur && right == cur) {
                count += dis(cur, left);
                cur = left;
            }else if (left != cur && right != cur){
                int disa = dis(cur, left);
                int disb = dis(cur, right);
                if (disa < disb){
                    count += disa;
                    cur = left;
                }else {
                    count += disb;
                    cur = right;
                }
            }
        }

        return count + dis(cur, 0);
    }
}
