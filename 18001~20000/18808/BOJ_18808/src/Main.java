import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static int n, m, k;
    private static int[][] note = new int[42][42];
    private static int[][] paper = new int[12][12];
    private static int r, c;

    private boolean canAttach(int x, int y) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (paper[i][j] == 1 && note[x + i][y + j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private void attach(int x, int y) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (paper[i][j] == 1) {
                    note[x + i][y + j] = 1;
                }
            }
        }
    }

    private void rotate() {
        int[][] temp = new int[12][12];
        for (int i = 0; i < r; i++) {
            System.arraycopy(paper[i], 0, temp[i], 0, c);
        }

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                paper[i][j] = temp[r - 1 - j][i];
            }
        }

        int tmp = r;
        r = c;
        c = tmp;
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            for (int i = 0; i < r; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < c; j++) {
                    paper[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int rot = 0; rot < 4; rot++) {
                boolean attached = false;
                for (int x = 0; x <= n - r; x++) {
                    for (int y = 0; y <= m - c; y++) {
                        if (canAttach(x, y)) {
                            attach(x, y);
                            attached = true;
                            break;
                        }
                    }
                    if (attached) break;
                }
                if (attached) break;
                rotate();
            }
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                total += note[i][j];
            }
        }
        System.out.println(total);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
