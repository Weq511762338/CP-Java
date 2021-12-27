package Bronze;

import java.util.Scanner;

class DoYouKnowYourABCs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");

        sc.close();
        int[] inputInt = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            inputInt[i] = Integer.parseInt(input[i]);
        }

        int temp =0 ;
        for(int i = 0; i < inputInt.length; i++){
            for(int j = 0; j < inputInt.length;j ++){
                if(inputInt[j] > inputInt[i]) {
                    temp = inputInt[j];
                    inputInt[j] = inputInt[i];
                    inputInt[i] = temp;
                }
            }
        }

        if(inputInt[0] + inputInt[1] == inputInt[2])
            System.out.println(inputInt[0] + " " + inputInt[1] + " " + inputInt[3]);
        else
            System.out.println(inputInt[0] + " " + inputInt[1] + " " + inputInt[2]);
    }
}
