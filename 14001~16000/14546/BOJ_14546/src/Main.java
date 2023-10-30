import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int T;
    int W;
    int L;
    int A;
    int B;
    int C;
    int D;
    char[][] board;
    boolean[][] isVisited;
    char type;

    public boolean execBFS() {
        Queue<int[]> que = new ArrayDeque<>();
        isVisited[A][B] = true;
        type = board[A][B];
        que.add(new int[]{A, B});

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[0] == C && cur[1] == D) {
                return true;
            }

            for (int i = 0; i < dir.length; i++) {
                int nX = cur[0] + dir[i][0];
                int nY = cur[1] + dir[i][1];

                if (nX <= 0 || nX > W || nY <= 0 || nY > L) {
                    continue;
                }
                if (isVisited[nX][nY]) {
                    continue;
                }
                if (board[nX][nY] != type) {
                    continue;
                }

                que.add(new int[]{nX, nY});
                isVisited[nX][nY] = true;
            }
        }

        return false;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            A = W - Integer.parseInt(st.nextToken()) + 1;
            D = Integer.parseInt(st.nextToken());
            C = W - Integer.parseInt(st.nextToken()) + 1;

            board = new char[W + 1][L + 1];
            for (int i = 1; i <= W; i++) {
                String input = br.readLine();
                for (int j = 1; j <= L; j++) {
                    board[i][j] = input.charAt(j - 1);
                }
            }

            isVisited = new boolean[W + 2][L + 2];
            if (!execBFS()) {
                sb.append("NO");
            } else {
                sb.append("YES");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
