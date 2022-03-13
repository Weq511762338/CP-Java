//package Silver;
import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class EmailFiling {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int a = 0; a < t; a ++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            LinkedList<Integer> before = new LinkedList();
            LinkedList<Integer> cur = new LinkedList();
            LinkedList<Integer> after = new LinkedList();
            st = new StringTokenizer(br.readLine());
            int[] count = new int[m+1];
            for(int i = 0; i < k; i++){
                int num = Integer.parseInt(st.nextToken());
                count[num]++;
                cur.add(num);
            }
            for(int i = k; i < n; i++){
                int num =Integer.parseInt(st.nextToken());
                count[num]++;
                after.add(num);
            }
            boolean possible = true;
            for(int folder = 1; folder <= m; folder++){
                if(count[folder] == 0)
                    continue;

                while(cur.size() != k){
                    if (!after.isEmpty())
                        cur.add(after.pollFirst());
                    else if (!before.isEmpty())cur.add(before.pollLast());
                    else break;
                }

                for(int i = 0; i < cur.size(); i++){
                    int num = cur.get(i);
                    if(num >= folder && num <= folder + k - 1){
                        count[num]--;
                        cur.remove(i);
                        i--;
                        if(!after.isEmpty()) cur.add(after.pollFirst());
                        else if(!before.isEmpty()) cur.addFirst(before.pollLast());
                    }
                }
                if(count[folder] == 0)
                    continue;

                while(count[folder] != 0 && !after.isEmpty()){
                    before.add(cur.pollFirst());
                    int num = after.pollFirst();
                    while(num >= folder && num <= folder + k - 1){
                        count[num]--;
                        if (after.isEmpty()) break;
                        num = after.pollFirst();
                    }
                    if (!(num >= folder && num <= folder + k - 1))
                        cur.add(num);
                }
                if(count[folder] != 0){
                    possible = false;
                    break;
                }
            }
            sb.append((possible ? "YES" : "NO") + "\n");
        }
        br.close();
        pw.print(sb);
        pw.close();
    }
}
