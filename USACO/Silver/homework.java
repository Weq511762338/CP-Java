//package Silver;

import java.util.*;
import java.io.*;
public class homework {
    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);

        BufferedReader br =new BufferedReader(new FileReader("homework.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("homework.out")));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        ArrayList<Integer> list = new ArrayList<>();
        long maxDeno = 0;
        long maxNum = 1;
        int min = arr[n-1];
        long sum = arr[n-1];
        for(int i = n-2; i >= 1; i--){
            sum += arr[i];
            min = Math.min(min, arr[i]);
            long curDeno = sum - min;
            long curNum = n-1-i;
            if (maxDeno*curNum < curDeno*maxNum){
                list.clear();
                list.add(i);
                maxDeno = curDeno;
                maxNum = curNum;
            }else if (maxDeno*curNum == curDeno*maxNum)
                list.add(i);
        }

        for(int i = list.size()-1; i >= 0 ; i--) pw.println(list.get(i));
        pw.close();
    }
}
