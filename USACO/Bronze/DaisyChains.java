package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DaisyChains {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] p = new int [N];
        String input = br.readLine();

        for(int i = 0; i < N; i++){
            p[i] = Integer.parseInt(input.split(" ")[i]);
        }

        int avr = 0;
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = i; j < N; j ++){
                avr = 0;
                if(j == i){
                    count ++;
                }else {
                    for (int a = i; a <= j; a++) {
                        avr += p[a];
                    }
                    if(avr%(j-i+1) == 0) {
                        avr = avr / (j - i + 1);
                        for(int a = i; a <= j; a++){
                            if (p[a] == avr) {
                                count++;
                                break;
                            }
                        }
                    }

                }

            }
        }

        System.out.println(count);


    }
}
