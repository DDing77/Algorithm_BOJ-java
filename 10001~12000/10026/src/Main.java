import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][] isVisited;
    static int groupCnt;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static void BFS(int x, int y) {
        groupCnt++;
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        que.add(y);
        isVisited[x][y] = true;

        while (!que.isEmpty()) {
            int nowX = que.poll();
            int nowY = que.poll();
            char target = map[nowX][nowY];
            for (int k = 0; k < 4; k++) {
                int nX = nowX + dir[k][0];
                int nY = nowY + dir[k][1];

                if (nX < 0 || nY < 0 || nX >= N || nY >= N) continue;
                if (isVisited[nX][nY]) continue;
                if (target != map[nX][nY]) continue;

                que.add(nX);
                que.add(nY);
                isVisited[nX][nY] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        isVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            map[i] = input.toCharArray();
        }

        groupCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j]) {
                    BFS(i, j);
                }
            }
        }
//        System.out.println(groupCnt);
        sb.append(groupCnt).append('\n');

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }

        isVisited = new boolean[N][N];
        groupCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j]) {
                    BFS(i, j);
                }
            }
        }

        sb.append(groupCnt).append('\n');

        System.out.print(sb);
    }
}
