package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GregorAndThePawnGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder ans = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String enemy = br.readLine() ;
            String greg = br.readLine();
            int count = 0;


            boolean[] enemyTaken = new boolean[n];
            for (int j = 0; j < n; j++) {
                if(greg.charAt(j) == '1') {
                    if (enemy.charAt(j) == '0')
                        count++;
                    else if (j >= 1 && enemy.charAt(j-1) == '1' && !enemyTaken[j-1]) {
                        count++;
                        enemyTaken[j-1] = true;
                    }
                    else if(j <= n-2 && enemy.charAt(j+1) == '1' && !enemyTaken[j+1]){
                        count++;
                        enemyTaken[j+1] = true;
                    }
                }
            }
            ans.append(count + "\n");
        }
               br.close();
        System.out.println(ans);
    }
}
