package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class twotables {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        double[] ans = new double[t];
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int tableW = Integer.parseInt(st.nextToken());
            int tableH = Integer.parseInt(st.nextToken());

            ans[i] = dis(x1, y1, x2, y2, tableW, tableH, w, h);
        }
        br.close();

        for (int i = 0; i < t; i++) {
            System.out.println(ans[i]);
        }
    }

    public static double dis(int x1, int y1, int x2, int y2, int moveableW, int moveableH, int w, int h) {
        int w1 = x2 - x1;
        int h1 = y2 - y1;

        if (w1 + moveableW <= w && h1 + moveableH > h)
            return Math.max(0, Math.min(moveableW - x1, x2 - (w - moveableW)));
        else if (w1 + moveableW > w && h1 + moveableH <= h)
            return Math.max(0, Math.min(y2 - (h - moveableH), moveableH - y1));
        else if (w1 + moveableW <= w && h1 + moveableH <= h)
            return Math.min(Math.max(0, Math.min(y2 - (h - moveableH), moveableH - y1)), Math.max(0, Math.min(moveableW - x1, x2 - (w - moveableW))));
        return -1;
    }
}
