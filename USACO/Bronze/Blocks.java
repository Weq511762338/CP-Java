package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Blocks {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw =new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        HashMap<Character, HashSet<Integer>> map = new HashMap<>();
        for(int i= 0; i < 4; i++){
            String str = br.readLine();
            for(int j = 0; j < 6; j++){
                char c = str.charAt(j);
                if (!map.containsKey(c)) map.put(c, new HashSet<>());
                map.get(c).add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i= 0; i < n; i++){
            String str = br.readLine();
            HashSet<Integer> set = new HashSet<>();
            if (help(0, str, set, map)) sb.append("YES" + "\n");
            else sb.append("NO" + "\n");
        }

        br.close();
        pw.print(sb);
        pw.close();
    }
    public static boolean help(int charIndex, String str, HashSet<Integer> used, HashMap<Character, HashSet<Integer>> map){
        if (charIndex == str.length()) return true;
        boolean done = false;
        char c = str.charAt(charIndex);
        if (!map.containsKey(c)) return false;
        for(int i : map.get(c)){
            if (used.contains(i)) continue;
            used.add(i);
            done = help(charIndex+1, str, used, map);
            used.remove(i);
            if (done) return true;
        }
        return false;
    }
}
