import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//public class Main {
//    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
//    static ArrayList<Integer> group;
//    static int N, group_cnt;
//    static String[] a;
//    static boolean[][] visit;
//    static StringBuilder sb = new StringBuilder();
//
//    static void dfs(int x, int y) {
//        group_cnt++;
//        visit[x][y] = true;
//        for (int k = 0; k < 4; k++) {
//            int nx = x + dir[k][0];
//            int ny = y + dir[k][1];
//            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
//            if (a[nx].charAt(ny) == '0') continue;
//            if (visit[nx][ny]) continue;
//            dfs(nx, ny);
//        }
//
//    }
//
//    static void solution() {
//        group = new ArrayList<>();
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                if (!visit[i][j] && a[i].charAt(j) == '1') {
//                    group_cnt = 0;
//                    dfs(i, j);
//                    group.add(group_cnt);
//                }
//            }
//        }
//        Collections.sort(group);
//        sb.append(group.size()).append("\n");
//        for (int i = 0; i < group.size(); i++) sb.append(group.get(i)).append('\n');
//        System.out.println(sb);
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
//        a = new String[N];
//        for (int i = 0; i < N; i++) {
//            a[i] = br.readLine();
//        }
//        visit = new boolean[N][N];
//
//        solution();
//    }
//}

public class Main {
    static int N;
    static String[] map;
    static boolean[][] isVisited;
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};
    static ArrayList<Integer> list = new ArrayList<>();
    static int groupCnt = 0;
    static StringBuilder sb = new StringBuilder();

    static void DFS(int x, int y) {
        groupCnt++;
        isVisited[x][y] = true;
        for(int k=0; k<4; k++) {
            int nx = x + dirX[k];
            int ny = y + dirY[k];
            if(nx <0 || ny <0 || nx >=N || ny >= N) continue;
            if(isVisited[nx][ny]) continue;
            if(map[nx].charAt(ny) == '0') continue;
            DFS(nx,ny);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N];
        isVisited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            map[i] = br.readLine();
        }


        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!isVisited[i][j] && map[i].charAt(j) == '1') {
                    groupCnt = 0;
                    DFS(i,j);
                    list.add(groupCnt);
                }
            }
        }
        Collections.sort(list);
        sb.append(list.size()).append('\n');
        for(int i: list) {
            sb.append(i).append('\n');
        }
        System.out.print(sb);
    }
}
