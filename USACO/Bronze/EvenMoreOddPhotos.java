package Bronze;
import java.util.*;
public class EvenMoreOddPhotos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int input = 0;
        int answer = 0;
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            input = sc.nextInt();
            if(input%2 == 0)
                even.add(input);
            else
                odd.add(input);
        }
        sc.close();
        int countE = even.size();
        int countO = odd.size();
        if(countE == countO || countE == countO + 1)
            answer = countE + countO;
        else if(countE > countO)
            answer = countO*2 + 1;
        else if(countE < countO){
                if ((countO - countE) % 3 == 0)
                    answer = 2 * countE + 2*((countO - countE))/ 3;
                else if ((countO - countE) % 3 == 1)
                    answer = 2 * countE + 2*((countO - countE) / 3) - 1;
                else
                    answer = 2 * countE + 2*((countO - countE) / 3) + 1;
        }
        System.out.println(answer);
    }
}
