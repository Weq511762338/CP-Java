package Chapter2;
/*
ID: weq51171
LANG: JAVA
TASK: castle
 */


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class castle {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("castle.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] plat = new int[n+1][m+1];
        int [][] visited = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                plat[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        ArrayList<Integer> room = new ArrayList<>();

        int mark = 1;
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (visited[i][j] == 0){
                    int result = floodfill(plat, visited, i, j, mark);
                    room.add(result);
                    if (result > max){
                        max = result;
                    }
                    mark++;
                }
            }
        }

        pw.println(room.size());
        pw.println(max);

        String[] wall = new String[3];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("===================");
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                System.out.print(plat[i][j] + " ");
            }
            System.out.println();
        }

        checkMax(plat, visited, 1, 1, wall, room);
        pw.println(prevMax(visited, wall, room));
        pw.println(wall[0] + " " + wall[1] + " " + wall[2]);
        pw.close();
    }

    public static int floodfill(int[][] plat, int[][] visited, int i, int j, int mark){
        int count = 0;
        if (visited[i][j] == 0) {
            count++;
            visited[i][j] = mark;
            if (plat[i][j] < 8 && i + 1 < plat.length) // south
                count += floodfill(plat, visited, i + 1, j, mark);

            if ((plat[i][j] < 4 || (plat[i][j] < 12 && plat[i][j] > 7))&& j + 1 < plat[0].length) // east
                count += floodfill(plat, visited, i, j + 1, mark);

            if ((plat[i][j]/2)%2 != 1 && i - 1 > 0) // north
                count += floodfill(plat, visited, i - 1, j, mark);

            if (plat[i][j] % 2 == 0 && j - 1 > 0) // west
                count += floodfill(plat, visited, i, j - 1, mark);
        }
        return count;
    }

    public static void checkMax(int[][] plat, int[][] visited, int i , int j, String[] wall, ArrayList<Integer> room) {
        if (j == visited[0].length) {
            if (i == visited.length-1)
                return ;
            checkMax(plat, visited, i + 1, 1, wall, room);
        }else {
            int current = room.get(visited[i][j] - 1);
            //north
            if (i - 1 > 0 && (plat[i][j] / 2) % 2 == 1) {
                if (visited[i][j] != visited[i-1][j]) {
                    if (current + room.get(visited[i - 1][j] - 1) > prevMax(visited, wall, room)) {
                        wall[0] = String.valueOf(i);
                        wall[1] = String.valueOf(j);
                        wall[2] = "N";
                    } else if (current + room.get(visited[i - 1][j] - 1) == prevMax(visited, wall, room)) {
                        if (j < Integer.parseInt(wall[1])) {
                            wall[0] = String.valueOf(i);
                            wall[1] = String.valueOf(j);
                            wall[2] = "N";
                        } else if (j == Integer.parseInt(wall[1])) {
                            if (i > Integer.parseInt(wall[0])) {
                                wall[0] = String.valueOf(i);
                                wall[1] = String.valueOf(j);
                                wall[2] = "N";
                            } else if (i == Integer.parseInt(wall[0]))
                                wall[2] = "N";
                        }
                    }
                }
            }
            //east
            if (j + 1 < plat[0].length && (plat[i][j] / 2 % 2 == 0 || plat[i][j] == 15) && plat[i][j] != 8 && plat[i][j] != 1) {
                if (visited[i][j] != visited[i][j+1]) {
                    if (current + room.get(visited[i][j + 1] - 1) > prevMax(visited, wall, room)) {
                        wall[0] = String.valueOf(i);
                        wall[1] = String.valueOf(j);
                        wall[2] = "E";
                    } else if (current + room.get(visited[i][j + 1] - 1) == prevMax(visited, wall, room)) {
                        if (j < Integer.parseInt(wall[1])) {
                            wall[0] = String.valueOf(i);
                            wall[1] = String.valueOf(j);
                            wall[2] = "E";
                        } else if (j == Integer.parseInt(wall[1])) {
                            if (i > Integer.parseInt(wall[0])) {
                                wall[0] = String.valueOf(i);
                                wall[1] = String.valueOf(j);
                                wall[2] = "E";
                            }
                        }
                    }
                }
            }
            checkMax(plat, visited, i, j + 1, wall, room);
        }
    }

    public static int prevMax(int[][] visited, String[] wall, ArrayList<Integer> room){
        if (wall[0]==null)
            return 0;
        if (wall[2].equals("N"))
            return room.get(visited[Integer.parseInt(wall[0])][Integer.parseInt(wall[1])]-1) + room.get(visited[Integer.parseInt(wall[0])-1][Integer.parseInt(wall[1])]-1);

        if (wall[2].equals("E"))
            return room.get(visited[Integer.parseInt(wall[0])][Integer.parseInt(wall[1])]-1) + room.get(visited[Integer.parseInt(wall[0])][Integer.parseInt(wall[1])+1]-1);
        return 0;
    }
}