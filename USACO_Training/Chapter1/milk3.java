/*
ID: weq51171
LANG: JAVA
TASK: milk3
 */

//package USACO_Training.Chapter1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class milk3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("milk3.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        br.close();

        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<String> tried = new ArrayList<>();
        solve(a, b, c, ans, 0, 0, c, tried);

        Collections.sort(ans);
        for (int i = 0; i < ans.size()-1; i++) {
            pw.print(ans.get(i) + " ");
        }
        pw.println(ans.get(ans.size()-1));
        pw.close();

    }

    public static void solve(int a, int b, int c, ArrayList<Integer> ans, int milkA, int milkB, int milkC, ArrayList<String> tried){
        if (tried.contains(milkA + " " + milkB + " " + milkC)){
            return ;
        }
        tried.add(milkA + " " + milkB + " " + milkC);

        if (milkA == 0 && ans.contains(milkC) == false)
            ans.add(milkC);

        int m_a = milkA;
        int m_b = milkB;
        int m_c = milkC;
        //from C to A
        milkC -= a - milkA;
        milkA = a;
        if (milkC < 0){
            milkA += milkC;
            milkC = 0;
        }
        solve(a, b, c, ans, milkA, milkB, milkC, tried);
        //from A to C
        milkC = m_c;
        milkB = m_b;
        milkA = m_a;
        milkA -= c - milkC;
        milkC = c;

        if (milkA < 0){
            milkC += milkA;
            milkA = 0;
        }
        solve(a, b, c, ans, milkA, milkB, milkC, tried);
        //from B to A
        milkC = m_c;
        milkB = m_b;
        milkA = m_a;
        milkB -= a - milkA;
        milkA = a;
        if (milkB < 0){
            milkA += milkB;
            milkB = 0;
        }
        solve(a, b, c, ans, milkA, milkB, milkC, tried);
        //from A to B
        milkC = m_c;
        milkB = m_b;
        milkA = m_a;

        milkA -= b - milkB;
        milkB = b;
        if (milkA < 0){
            milkB += milkA;
            milkA = 0;
        }
        solve(a, b, c, ans, milkA, milkB, milkC, tried);
        //from C to B
        milkC = m_c;
        milkB = m_b;
        milkA = m_a;

        milkC -= b - milkB;
        milkB = b;
        if (milkC < 0){
            milkB += milkC;
            milkC = 0;
        }
        solve(a, b, c, ans, milkA, milkB, milkC, tried);
        //from B to C
        milkC = m_c;
        milkB = m_b;
        milkA = m_a;

        milkB -= c - milkC;
        milkC = c;
        if (milkB < 0){
            milkC += milkB;
            milkB = 0;
        }
        solve(a, b, c, ans, milkA, milkB, milkC, tried);
    }
}
