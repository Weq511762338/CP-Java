package Gold;

import java.io.*;
import java.util.StringTokenizer;

public class BarnPainting {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("barnpainting.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("barnpainting.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        /*
        first mark every individual node if they can already be painted or defined how many patterns <=2

        secondly compute nodes that can't be defined and are connected. Multiplication

        possibly no valid way???
         */

        long ans = 1;

        int[] color = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n-1; i++) {

        }

    }
}
