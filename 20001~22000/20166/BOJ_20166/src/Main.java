import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    private int N;
    private int M;
    private int K;
    private char[][] board;
    private String[] likes;
    private int maxLength;
    private HashMap<String, Integer> map;

    private void execDFS(StringBuilder str, int x, int y) {

        if (map.containsKey(str.toString())) {
            map.put(str.toString(), map.get(str.toString()) + 1);
        }
        if (str.length() == maxLength) {
            return;
        }
        for (int[] dir : dirs) {
            int nX = x + dir[0];
            int nY = y + dir[1];

            if (nX < 0) {
                nX = N - 1;
            }
            if (nX >= N) {
                nX = 0;
            }
            if (nY < 0) {
                nY = M - 1;
            }
            if (nY >= M) {
                nY = 0;
            }
            str.append(board[nX][nY]);
            execDFS(str, nX, nY);
            str.deleteCharAt(str.length() - 1);
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        likes = new String[K];
        map = new HashMap<>();
        for (int i = 0; i < K; i++) {
            likes[i] = br.readLine();
            maxLength = Math.max(maxLength, likes[i].length());
            map.put(likes[i], 0);
        }

        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp.setLength(0);
                execDFS(temp.append(board[i][j]), i, j);
            }
        }

        for (String like : likes) {
            sb.append(map.get(like)).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
