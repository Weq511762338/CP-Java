import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class AssignmentEfficiency {
    public static class Work implements Comparable<Work> {
        int id, points, time;

        public Work(int id, int points, int time) {
            this.id = id;
            this.points = points;
            this.time = time;
        }

        @Override
        public int compareTo(Work o) {
            Work a = this;
            Work b = o;
            if (a.points * b.time == b.points * a.time)
                return a.id - b.id;

            long n1 = a.points * b.time;
            long n2 = b.points * a.time;
            return n1 > n2 ? -1 : 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        ArrayList<Work> list = new ArrayList<>();
        for(int i = 0; i< n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list.add(new Work(id, p, t));
        }
        br.close();
        Collections.sort(list);
        for(Work w : list){
            pw.println(w.id);
        }
        pw.close();
    }
}
