package Bronze;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StuckInARut {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] location = new int[N][2];
        String [] direction = new String[N];
        String input;
        for(int i = 0; i < N; i++){
            input = br.readLine();
            direction[i] = input.split(" ")[0];//direction
            location[i][0] = Integer.parseInt(input.split(" ")[1]);//x
            location[i][1] = Integer.parseInt(input.split(" ")[2]);//y
        }




        int count = 0;
        int []minCount = new int[N];
        int []status = new int[N]; // 0 -> stop  1-> moving
        for(int i = 0; i < N; i++){
            count = 0;
            for (int j = i+1; j < N; j++) {
                if (direction[i].equals("N")) {
                    if (direction[j].equals("E")) {
                        if (location[j][1] - location[i][1] >= 0 && location[i][0] - location[j][0] >= 0) {
                            if (location[j][1] - location[i][1] > location[i][0] - location[j][0]) {

                                count = location[j][1] - location[i][1];
                                if (minCount[i] == 0)
                                    minCount[i] = count;
                                if (count < minCount[i])
                                    minCount[i] = count;

                            }
                        }
                    }
                } else {
                    if (direction[j].equals("N")) {
                        if (location[i][1] - location[j][1] >= 0 && location[j][0] - location[i][0] >= 0) {
                            if (location[j][0] - location[i][0] > location[i][1] - location[j][1]) {
                                count = location[j][0] - location[i][0];
                                if (minCount[i] == 0)
                                    minCount[i] = count;
                                if (count < minCount[i])
                                    minCount[i] = count;
                            }
                        }
                    }
                }
            }
        }



        for(int i = 0; i < N; i++) {
                if (minCount[i] == 0)
                    System.out.println("Infinity");
                else
                    System.out.println(minCount[i]);
            }

    }
}
