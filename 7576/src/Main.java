import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[][] map;
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};
    static boolean[][] isVisited;
    static int ripeTomatoCnt = 0;
    static int rowTomatoCnt = 0;
    static Queue<Integer> que = new LinkedList<>();

    static int BFS() {
        if (rowTomatoCnt == 0) return 0;
        int time = 0;
        while (!que.isEmpty()) {
            time++;
            int length = que.size() / 2;
            for (int i = 0; i < length; i++) {
                int x = que.poll();
                int y = que.poll();
                for (int k = 0; k < 4; k++) {
                    int nX = x + dirX[k];
                    int nY = y + dirY[k];
                    if (nX < 0 || nY < 0 || nX >= N || nY >= M) continue;
                    if (isVisited[nX][nY]) continue;
                    if (map[nX][nY] == 1 || map[nX][nY] == -1) continue;
                    map[nX][nY] = 1;
                    isVisited[nX][nY] = true;
                    rowTomatoCnt--;
                    if (rowTomatoCnt == 0) return time;
                    que.add(nX);
                    que.add(nY);
                }
            }
        }
        if (rowTomatoCnt != 0) return -1;
        return time;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) { // 익은 토마토
                    ripeTomatoCnt++;
                    que.add(i);
                    que.add(j);
                    isVisited[i][j] = true;
                } else if (map[i][j] == 0) {
                    rowTomatoCnt++;
                }
            }
        }
        System.out.println(BFS());
    }
}
