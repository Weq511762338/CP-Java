package Bronze;


import java.util.*;
public class UdderedButNotHerd {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String alp = sc.next();
        String heard = sc.next();
        sc.close();
        int count = 1;

        for (int i = 1; i < heard.length(); i++) {
            if(alp.indexOf(heard.charAt(i)) > alp.indexOf(heard.charAt(i-1))){
                ;
            }else{
                count++;
            }
        }

/*
check first heard where at alp
check next heard within alp after first
yes: continue doing this for next heard
no: count ++, start over next heard
 */

        System.out.println(count);
    }
}
