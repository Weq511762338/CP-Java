package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

// only store and later check for to letter combninations that doesn't work

public class SubsetEquality {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String str1 = br.readLine();
        String str2 = br.readLine();
        int n = Integer.parseInt(br.readLine());

        StringBuilder ans = new StringBuilder();
        HashSet<HashSet<Character>> set = new HashSet<>();
        int[] letter1 = new int[18];
        int[] letter2 = new int[18];
        for (int i = 0; i < str1.length(); i++) {
            letter1[str1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < str2.length(); i++) {
            letter2[str2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 18; i++) {
            for (int j = i+1; j < 18; j++) {
                char c1 = (char) (i + 'a');
                char c2 = (char) (j + 'a');
                if(!check(str1, str2, c1, c2))
                    set.add(new HashSet<Character>(){{add(c1); add(c2);}});
            }
        }
        for(int i = 0; i < 18; i++) {
            if(letter1[i] != letter2[i]){
                HashSet<Character> s = new HashSet<>();
                s.add((char) (i + 'a'));
                set.add(s);
            }
        }

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            HashSet<Character> code = new HashSet<>();
            for (int j = 0; j < s.length(); j++) {
                code.add(s.charAt(j));
            }
            boolean flag = true;
            for (HashSet<Character> a : set) {
                if (code.containsAll(a)) {
                    flag = false;
                    break;
                }
            }
            if (flag) ans.append("Y");
            else ans.append("N");
        }

        pw.println(ans);
        pw.close();
    }

    public static boolean check(String str1, String str2, char char1, char char2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == char1 || str1.charAt(i) == char2) {
                sb1.append(str1.charAt(i));
            }
        }
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) == char1 || str2.charAt(i) == char2) {
                sb2.append(str2.charAt(i));
            }
        }
        return sb1.toString().equals(sb2.toString());
    }
}
