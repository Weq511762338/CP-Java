//package Silver;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class triangles {

    public static class Post{
        int x;
        int y;
        long sumx;
        long sumy;

        public Post(int x, int y, long sumx, long sumy) {
            this.x = x;
            this.y = y;
            this.sumx = sumx;
            this.sumy = sumy;
        }
    }
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);

        BufferedReader br = new BufferedReader(new FileReader("triangles.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Post> list = new ArrayList<>();
        HashMap<Integer, ArrayList<Post>> hor = new HashMap<>();
        HashMap<Integer, ArrayList<Post>> ver = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer( br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Post p = new Post(x, y, 0, 0);
            list.add(p);

            if (!hor.containsKey(y)) hor.put(y, new ArrayList<>());
            hor.get(y).add(p);
            if (!ver.containsKey(x)) ver.put(x, new ArrayList<>());
            ver.get(x).add(p);
        }
        br.close();

        for(Map.Entry<Integer,ArrayList<Post>> entry : hor.entrySet()){
            Collections.sort(entry.getValue(), (a, b) -> a.x - b.x);
            ArrayList<Post> xpos = entry.getValue();
            if (xpos.size() >= 2) {
                long sum = 0;
                for (int i = 0; i < xpos.size(); i++) {
                    sum += xpos.get(i).x - xpos.get(0).x;
                }
                xpos.get(0).sumx = sum;

                for(int i = 0; i < xpos.size()-1; i++){
                    int dis = xpos.get(i+1).x - xpos.get(i).x;
                    sum += dis*(2L *i-xpos.size()+2);
                    xpos.get(i+1).sumx = sum;
                }
            }
        }
        for(Map.Entry<Integer,ArrayList<Post>> entry : ver.entrySet()){
            Collections.sort(entry.getValue(), (a, b) -> a.y - b.y);
            ArrayList<Post> ypos = entry.getValue();
            if (ypos.size() >= 2) {
                long sum = 0;
                for (int i = 0; i < ypos.size(); i++) {
                    sum += ypos.get(i).y - ypos.get(0).y;
                }
                ypos.get(0).sumy = sum;

                for(int i = 0; i < ypos.size()-1; i++){
                    int dis = ypos.get(i+1).y - ypos.get(i).y;
                    sum += dis*(2L *i-ypos.size()+2);
                    ypos.get(i+1).sumy = sum;
                }
            }
        }
        long ans = 0;

        for(Post p : list){
            ans += p.sumx*p.sumy;
        }
        pw.println(ans%1000000007);
        pw.close();


    }
}
