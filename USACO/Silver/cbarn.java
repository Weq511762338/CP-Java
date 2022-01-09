//package Silver;

import java.io.*;
import java.util.*;

public class cbarn {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("cbarn.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("cbarn.out"));
        int n = Integer.parseInt(br.readLine());

        TreeMap<Integer,Integer> original = new TreeMap<>();

        int count = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a == 0) count ++;
            else original.put(i, a);
            arr[i] = a;
        }
        long ans = Long.MAX_VALUE;
        for(int i = n-1; i >= 0; i--){
            if (arr[i] == 0) {
                TreeMap<Integer,Integer> occupied = new TreeMap<>(original);
                long res = 0;
                int index = i;
                int countInside = count;
                while (countInside != 0) {
                    if (!occupied.containsKey(index)) {
                        if (occupied.lowerKey(index) == null) {
                            int key = occupied.lastKey();
                            occupied.put(key, occupied.get(key) - 1);
                            if (occupied.get(key) == 0) {
                                occupied.remove(key);
                                countInside++;
                            }
                            res += (long) (index - key + n) * (index - key + n);

                        } else {
                            int key = occupied.lowerKey(index);
                            occupied.put(key, occupied.get(key) - 1);
                            if (occupied.get(key) == 0) {
                                occupied.remove(key);
                                countInside++;
                            }

                            res += (long) (index - key) * (index - key);
                        }
                        countInside--;
                    }
                    index--;
                    if (index < 0) index = n - 1;
                }
                ans = Math.min(ans, res);
            }
        }
        br.close();
        pw.println(ans);
        pw.close();
    }
}
