/*
ID: weq51171
LANG: JAVA
TASK: friday
 */

package USACO_Training;

import java.io.*;
import java.util.StringTokenizer;

public class friday {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("friday.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        br.close();
        int dayInWeek = 2;
        int[] freq = new int[7];// SAT, SUN, MON...

        for (int year = 1900; year < 1900 + n; year++) {
            for (int month = 1; month <= 12; month++) {
                freq[(dayInWeek + (13 - 1)) % 7]++;
                if (month == 4 || month == 6 || month == 9 || month == 11) {//30days
                    dayInWeek = (dayInWeek + 30) % 7;
                } else if (month == 2) {
                    if ((year % 100 == 0 && year % 400 == 0) || (year % 100 != 0 && year % 4 == 0)) {//29days
                        dayInWeek = (dayInWeek + 29) % 7;
                    } else {//28days
                        dayInWeek = (dayInWeek + 28) % 7;
                    }
                } else {//31days
                    dayInWeek = (dayInWeek + 31) % 7;
                }
            }

        }

        for (int i = 0; i < 6; i++) {
            pw.print(freq[i] + " ");
        }
        pw.println(freq[6]);
        pw.close();
    }

}
