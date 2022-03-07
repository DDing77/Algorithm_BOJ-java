import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int H, M, N;
    static int[] dirX = {0, 0, -1, 1, 0, 0};
    static int[] dirY = {0, 0, 0, 0, -1, 1};
    static int[] dirZ = {1, -1, 0, 0, 0, 0};
    static int[][][] map;
    static boolean[][][] isVisited;
    static int rowTomatoCnt = 0;
    static int ripeTomatoCnt = 0;
    static Queue<Integer> que = new LinkedList<>();

    static int BFS() {
        if (rowTomatoCnt == 0) return 0;
        int time = 0;
        while (!que.isEmpty()) {
            time++;
            int len = que.size() / 3;
            for (int i = 0; i < len; i++) {
                int h = que.poll();
                int x = que.poll();
                int y = que.poll();
                for (int k = 0; k < 6; k++) {
                    int nH = h + dirZ[k];
                    int nX = x + dirX[k];
                    int nY = y + dirY[k];
                    if (nH < 0 || nH >= H || nX < 0 || nX >= N || nY < 0 || nY >= M) continue;
                    if (isVisited[nH][nX][nY]) continue;
                    if (map[nH][nX][nY] == -1 || map[nH][nX][nY] == 1) continue;
                    map[nH][nX][nY] = 1;
                    rowTomatoCnt--;
                    ripeTomatoCnt++;
                    if (rowTomatoCnt == 0) return time;
                    que.add(nH);
                    que.add(nX);
                    que.add(nY);
                    isVisited[nH][nX][nY] = true;
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
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        isVisited = new boolean[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[h][i][j] = Integer.parseInt(st.nextToken());
                    if (map[h][i][j] == 1) {
                        que.add(h);
                        que.add(i);
                        que.add(j);
                        isVisited[h][i][j] = true;
                        ripeTomatoCnt++;
                    } else if (map[h][i][j] == 0) rowTomatoCnt++;
                }
            }
        }
        System.out.println(BFS());
    }
}
