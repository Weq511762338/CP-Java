package Silver;
import java.io.*;
import java.util.*;

public class cowjump {
    static double curX;

    static class Point{
        long x;
        long y;
        int segIndex;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Segment{
        Point p;
        Point q;
        int index;
        public Segment(Point p, Point q) {
            this.p = p;
            this.q = q;
        }
    }

    public static double eval(Segment a){
        if (a.p.x == a.q.x) return a.p.y;
        return a.p.y + (a.q.y-a.p.y) *(curX - a.p.x) / (a.q.x - a.p.x);
    }
    public static int sign(long x){
        return x == 0 ? 0 : x < 0 ? -1 : 1;
    }
    public static int times(Point p1, Point p2){
        return sign( p1.x * p2.y -  p1.y * p2.x);
    }
    public static Point minus(Point p1, Point p2){
        return new Point(p1.x-p2.x, p1.y - p2.y);
    }
    public static boolean intersect(Segment s1, Segment s2){
        Point a = s1.p;
        Point b = s1.q;
        Point c = s2.p;
        Point d = s2.q;
        return times(minus(d, a), minus(b, a)) * times(minus(b, a), minus(c, a)) >= 0 && times(minus(b, c), minus(d, c)) * times(minus(d, c), minus(a, c)) >= 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

//        BufferedReader br = new BufferedReader(new FileReader("cowjump.in"));
//        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));

        int n = Integer.parseInt(br.readLine());
        Segment[] seg = new Segment[n+1];
        ArrayList<Point> pt = new ArrayList<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Point a = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Point b = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            a.segIndex = i+1;
            b.segIndex = i+1;
            seg[i+1] = new Segment(a, b);
            seg[i+1].index = i+1;
            pt.add(a);
            pt.add(b);
        }
        br.close();
        Collections.sort(pt, (a, b)-> (int) (a.x == b.x ? a.y- b.y : a.x - b.x));

        TreeSet<Segment> active = new TreeSet<>(new Comparator<>() {
            @Override
            public int compare(Segment o1, Segment o2) {
                if (o1.index == o2.index) return 0;
                return eval(o1) < eval(o2) ? -1 : 1;
            }
        });
        int ans1 = -1;
        int ans2 = -1;
        for(int i = 0; i < n*2; i++){
            ans1 = pt.get(i).segIndex;
            curX = pt.get(i).x;
            Segment line = active.ceiling(seg[ans1]);
            if (active.contains(seg[ans1])){
                active.remove(line);
                Segment after = active.ceiling(line);
                Segment before = active.floor(line);
                if (after != null && before != null){
                    if (intersect(after, before)){
                        ans1 = before.index;
                        ans2 = after.index;
                        break;
                    }
                }
            }else{
                line = seg[ans1];
                Segment after = active.ceiling(line);
                Segment before = active.floor(line);
                if (after != null && intersect(after, line)) {ans2 = after.index; break;}
                if (before != null && intersect(before, line)) {ans2 = before.index; break;}
                active.add(line);
            }
        }

        if (ans1 > ans2){
            int t = ans1;
            ans1 = ans2;
            ans2 = t;
        }
        int ans2count = 0;
        for (int i = 1; i <= n; i++) {
            if (i != ans2 && intersect(seg[ans2], seg[i])) ans2count++;
        }
        pw.println((ans2count > 1 ? ans2 : ans1));
        pw.close();
    }
}
