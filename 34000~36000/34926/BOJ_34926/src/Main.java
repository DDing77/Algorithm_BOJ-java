import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int K;
    private char[] board;

    private boolean isReachable() {
        Queue<Integer> que = new ArrayDeque<>();
        boolean[] isVisited = new boolean[N];
        que.add(0);
        isVisited[0] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();

            if (cur == N - 1) {
                return true;
            }

            int nextPos = cur + 1;
            if (nextPos < N && !isVisited[nextPos] && board[nextPos] == '_') {
                isVisited[nextPos] = true;
                que.add(nextPos);
            }

            nextPos = cur + K;
            if (nextPos < N && !isVisited[nextPos] && board[nextPos] == '_') {
                isVisited[nextPos] = true;
                que.add(nextPos);
            }
        }
        return false;
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = br.readLine().toCharArray();

        if (isReachable()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
