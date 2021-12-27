package Bronze;
import java.util.*;
public class JustStalling {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long [] a = new long [n];//using big integer?
        long [] b = new long [n];

        for(int i = 0 ; i < n; i++){
            a[i] = sc.nextInt();
        }
        for(int i = 0 ; i < n; i++){
            b[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);
        long ans = 1;

/*
check the stalls each cow can get into
placehold it then do the next
 */
        int count = 0;
        for (int i = n-1; i >= 0; i--) {
            count = 0 - (n - 1 - i);
            for (int j = n-1; j >= 0; j--) {
                if(a[i] <= b[j])
                    count++;
                else
                    break;
            }
            ans *= count;
        }


        System.out.println(ans);
    }
}
