import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int eatCnt = 0;
    static int sharkSize = 2;
    static int moveCnt = 0;
    static int[] cur;
    static int[][] map;
    static boolean[][] isVisited;
    static int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    cur = new int[]{i, j};
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] != o2[2] ?
                    Integer.compare(o1[2], o2[2]) : (o1[0] != o2[0] ?
                    Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1])));
            isVisited = new boolean[N][N];

            pq.add(new int[]{cur[0], cur[1], 0});
            isVisited[cur[0]][cur[1]] = true;

            boolean check = false;

            while (!pq.isEmpty()) {
                cur = pq.poll();

                if (map[cur[0]][cur[1]] != 0 && map[cur[0]][cur[1]] < sharkSize) {
                    map[cur[0]][cur[1]] = 0;
                    eatCnt++;
                    moveCnt += cur[2];
                    check = true;
                    break;
                }

                for (int k = 0; k < 4; k++) {
                    int nX = cur[1] + dir[k][0];
                    int nY = cur[0] + dir[k][1];

                    if (nX < 0 || nY < 0 || nX >= N || nY >= N) continue;
                    if (isVisited[nY][nX]) continue;
                    if (map[nY][nX] > sharkSize) continue;

                    pq.add(new int[]{nY, nX, cur[2] + 1});
                    isVisited[nY][nX] = true;
                }
            }

            if (!check) break;
            if (sharkSize == eatCnt) {
                sharkSize++;
                eatCnt = 0;
            }
        }
        System.out.println(moveCnt);
    }
}
