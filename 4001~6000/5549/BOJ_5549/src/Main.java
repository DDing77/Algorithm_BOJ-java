import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int M;
    int K;
    int[][] jungle;
    int[][] sea;
    int[][] ice;

    private void update(int r, int c, int[][] type) {
        while (r <= N) {
            int cc = c;
            while (cc <= M) {
                type[r][cc] += 1;
                cc += cc & -cc;
            }
            r += r & -r;
        }
    }

    private int getPrefixSum(int r, int c, int[][] type) {
        int sum = 0;
        while (r > 0) {
            int cc = c;
            while (cc > 0) {
                sum += type[r][cc];
                cc -= cc & -cc;
            }
            r -= r & -r;
        }
        return sum;
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        jungle = new int[N + 1][M + 1];
        sea = new int[N + 1][M + 1];
        ice = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {
                char ch = input[j - 1];
                if (ch == 'J') {
                    update(i, j, jungle);
                } else if (ch == 'O') {
                    update(i, j, sea);
                } else if (ch == 'I') {
                    update(i, j, ice);
                }
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int jungleSum = getPrefixSum(r2, c2, jungle)
                    - getPrefixSum(r2, c1 - 1, jungle) - getPrefixSum(r1 - 1, c2, jungle)
                    + getPrefixSum(r1 - 1, c1 - 1, jungle);
            int seaSum = getPrefixSum(r2, c2, sea)
                    - getPrefixSum(r2, c1 - 1, sea) - getPrefixSum(r1 - 1, c2, sea)
                    + getPrefixSum(r1 - 1, c1 - 1, sea);
            int iceSum = getPrefixSum(r2, c2, ice)
                    - getPrefixSum(r2, c1 - 1, ice) - getPrefixSum(r1 - 1, c2, ice)
                    + getPrefixSum(r1 - 1, c1 - 1, ice);

            sb.append(jungleSum).append(" ").append(seaSum).append(" ").append(iceSum).append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
