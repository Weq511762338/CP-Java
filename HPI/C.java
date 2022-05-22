import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        br.close();
        int max = 0;
        boolean increasing = true;
        boolean equal = false;
        int last = list.get(0);
        int count = 1;
        for(int i = 1; i < n; i++){
            int num = list.get(i);
            if (equal){
                if (num == last){
                    max = Math.max(count, max);
                    count = 1;
                    continue;
                }
                increasing = num > last;
            }
            if (increasing){
                if (num > last) count++;
                else if (num == last){
                    max = Math.max(count, max);
                    count = 1;
                    equal = true;
                }else {
                    count++;
                    increasing = false;
                }
            } else{
                if (num < last) count++;
                else if (num == last){
                    max = Math.max(count, max);
                    count = 1;
                    equal = true;
                }else{
                    max = Math.max(count, max);
                    count = 2;
                    increasing = true;
                }
            }

            last = num;
            max = Math.max(count, max);
        }
        System.out.println(max);
    }
}
