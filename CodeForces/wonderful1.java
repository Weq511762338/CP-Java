package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class wonderful1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] q = new String[n];

        for (int i = 0; i < n; i++) {
            q[i] = br.readLine(); }

        br.close();
        for (int i = 0; i < n; i++) {
            String str = q[i];
            HashSet<Character> dif = new HashSet<>();
            HashSet<Character> rep = new HashSet<>();
            for (int j = 0; j < str.length(); j++) {
                if (dif.contains(str.charAt(j)))
                    rep.add(str.charAt(j));
                dif.add(str.charAt(j));
            }
            int ans = dif.size()+rep.size();
            ans /= 2;
            System.out.println(ans);

        }

    }
}
