import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int K;
    static char[][] board;
    static int[][] prefixSumB;
    static int[][] prefixSumW;

    static int[][] getPrefixSum(char color) {
        int[][] prefix = new int[N + 1][M + 1];
        int val;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                val = 0;
                if ((i + j) % 2 == 0) {
                    if (board[i][j] != color) {
                        val = 1;
                    }
                } else {
                    if (board[i][j] == color) {
                        val = 1;
                    }
                }
                prefix[i + 1][j + 1] = prefix[i + 1][j] + prefix[i][j + 1] - prefix[i][j] + val;
            }
        }

        return prefix;
    }

    public static int getMin(int[][] prefixSum) {
        int min = Integer.MAX_VALUE;

        for (int i = K; i <= N; i++) {
            for (int j = K; j <= M; j++) {
                int num = prefixSum[i][j] - prefixSum[i][j - K] - prefixSum[i - K][j] + prefixSum[i - K][j - K];
                min = Math.min(min, num);
            }
        }

        return min;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        prefixSumB = getPrefixSum('B');
        prefixSumW = getPrefixSum('W');

        System.out.println(Math.min(getMin(prefixSumB), getMin(prefixSumW)));
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
