import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private int M;
    private int n;
    private int curX;
    private int curY;
    private int dirIdx;

    private boolean isIn(int x, int y) {
        return 0 <= x && x < M && 0 <= y && y < M;
    }

    private void rotateDir(int rotateDir) {
        if (rotateDir == 0) {
            dirIdx++;
            if (dirIdx > 3) {
                dirIdx = 0;
            }
        } else if (rotateDir == 1) {
            dirIdx--;
            if (dirIdx < 0) {
                dirIdx = 3;
            }
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        curX = 0;
        curY = 0;
        dirIdx = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int x = Integer.parseInt(st.nextToken());

            if (op.equals("TURN")) {
                rotateDir(x);
            } else if (op.equals("MOVE")) {
                int nextX = curX + dirs[dirIdx][0] * x;
                int nextY = curY + dirs[dirIdx][1] * x;
                if (!isIn(nextX, nextY)) {
                    System.out.println("-1");
                    return;
                }
                curX = nextX;
                curY = nextY;
            }
        }

        System.out.println(curY + " " + curX);
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
