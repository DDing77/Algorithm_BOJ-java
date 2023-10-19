import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int metres;
    int N;
    int M;
    char[][] board;
    PriorityQueue<Integer> pq;
    int room;

    public void execBFS(int x, int y) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});
        board[x][y] = 'I';
        int cnt = 1;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int i = 0; i < dir.length; i++) {
                int nX = cur[0] + dir[i][0];
                int nY = cur[1] + dir[i][1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }
                if (board[nX][nY] == 'I') {
                    continue;
                }

                que.add(new int[]{nX, nY});
                board[nX][nY] = 'I';
                cnt++;
            }
        }
        pq.add(cnt);
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        metres = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == '.') {
                    execBFS(i, j);
                }
            }
        }

        room = 0;
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            if (metres - cur < 0) {
                break;
            } else {
                metres -= cur;
                room++;
            }
        }

        sb.append(room);
        if (room == 1) {
            sb.append(" room, ");
        } else {
            sb.append(" rooms, ");
        }
        sb.append(metres + " square metre(s) left over");
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
