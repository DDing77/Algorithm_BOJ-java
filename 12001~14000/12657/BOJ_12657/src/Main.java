import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    private int T;
    private int H;
    private int W;
    private int[][] board;
    private int[][] idxBoard;
    private HashMap<Integer, Character> labelMap = new HashMap<>();

    private int find(int x, int y) {
        if (idxBoard[x][y] != -1) {
            return idxBoard[x][y];
        }

        int nextX = x;
        int nextY = y;
        int minHeight = board[x][y];

        for (int[] dir : dirs) {
            int nX = x + dir[0];
            int nY = y + dir[1];

            if (nX < 0 || nX >= H || nY < 0 || nY >= W) {
                continue;
            }

            if (board[nX][nY] < minHeight) {
                nextX = nX;
                nextY = nY;
                minHeight = board[nX][nY];
            }
        }

        if (nextX == x && nextY == y) {
            idxBoard[x][y] = x * W + y;
            return idxBoard[x][y];
        }

        idxBoard[x][y] = find(nextX, nextY);
        return idxBoard[x][y];
    }

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            board = new int[H][W];
            idxBoard = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    idxBoard[i][j] = -1;
                }
            }

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    find(i, j);
                }
            }

            labelMap.clear();
            char nextLabel = 'a';

            sb.append("Case #").append(tc).append(": ").append("\n");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    int id = idxBoard[i][j];

                    if (!labelMap.containsKey(id)) {
                        labelMap.put(id, nextLabel++);
                    }

                    if (j > 0) {
                        sb.append(" ");
                    }
                    sb.append(labelMap.get(id));
                }
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
