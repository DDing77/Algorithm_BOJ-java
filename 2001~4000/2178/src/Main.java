import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[][] visit;
    static int[][] dist;
    static int[][] map;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static void bfs(int x, int y) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        q.add(y);
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int cur_x = q.poll();
            int cur_y = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur_x + dir[k][0];
                int ny = cur_y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visit[nx][ny] || map[nx][ny] == 0) continue;
                q.add(nx);
                q.add(ny);
                map[nx][ny] = map[cur_x][cur_y] + 1;
                visit[nx][ny] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        bfs(0,0);
        System.out.println(map[N-1][M-1]);
//        for(int i=0; i<N; i++) {
//            for(int j=0; j<M; j++) {
//                System.out.print(map[i][j]);
//            }
//            System.out.println(" ");
//        }
    }
}
