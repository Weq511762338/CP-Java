//package Silver;

import java.io.*;
import java.util.*;

public class rental {

    static class Farm{
        int price;
        int slot;

        public Farm(int slot, int price) {
            this.price = price;
            this.slot = slot;
        }
    }
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("rental.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("rental.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        ArrayList<Integer> cow = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cow.add(Integer.parseInt(br.readLine()));
        }

        PriorityQueue<Farm> sell = new PriorityQueue<>(Comparator.comparingInt(a -> -a.price));
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            sell.add(new Farm(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        ArrayList<Integer> rent = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            rent.add(Integer.parseInt(br.readLine()));
        }
        br.close();
        long ans = 0;
        Collections.sort(cow, Comparator.comparingInt(a -> a));
        Collections.sort(rent, Comparator.comparingInt(a -> -a));

        // first rent all of them out
        int rentIndex = 0;
        for(; rentIndex < n && rentIndex < r; rentIndex++){
            ans += rent.get(rentIndex);
        }
        rentIndex--;
        for(int i = n-1; i >= 0; i--){
            long cur = ans;
            int prod = cow.get(i);
            if (i <= rentIndex){
                cur -= rent.get(rentIndex);
                rentIndex--;
            }

            while(!sell.isEmpty() && prod > 0){
                Farm f = sell.peek();
                int min = Math.min(f.slot, prod);
                cur += (long) min *f.price;
                f.slot -= min;
                prod -= min;
                if (f.slot == 0) sell.poll();
            }
            if (cur < ans)
                break;
            ans = cur;
        }
        pw.println(ans);
        pw.close();
    }
}
