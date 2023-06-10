import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N;
    static int M;
    static char[][] map;
    static Queue<int[]> que;
    static boolean[][] isVisited;
    static int res;

    public static void execBFS() {
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int k = 0; k < 4; k++) {
                int nX = cur[0] + dir[k][0];
                int nY = cur[1] + dir[k][1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }

                if (isVisited[nX][nY]) {
                    continue;
                }

                if (map[nX][nY] == 'X') {
                    continue;
                }

                if (map[nX][nY] == 'P') {
                    res++;
                }

                que.add(new int[]{nX, nY});
                isVisited[nX][nY] = true;
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        que = new LinkedList<>();
        isVisited = new boolean[N][M];

        String input;
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'I') {
                    que.add(new int[]{i, j});
                    isVisited[i][j] = true;
                }
            }
        }

        res = 0;
        execBFS();

        if (res == 0) {
            System.out.println("TT");
            return;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
