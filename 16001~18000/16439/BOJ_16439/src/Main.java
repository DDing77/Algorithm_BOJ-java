import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int[][] scores;
    private boolean[] checkArr;
    private int res;

    private void execDFS(int depth, int idx) {
        if (depth == 3) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                int curMax = 0;
                for (int j = 0; j < M; j++) {
                    if (checkArr[j]) {
                        curMax = Math.max(curMax, scores[i][j]);
                    }
                }
                sum += curMax;
            }
            res = Math.max(res, sum);
            return;
        }

        for (int i = idx; i < M; i++) {
            if (!checkArr[i]) {
                checkArr[i] = true;
                execDFS(depth + 1, i + 1);
                checkArr[i] = false;
            }
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        scores = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        checkArr = new boolean[M];
        execDFS(0, 0);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
