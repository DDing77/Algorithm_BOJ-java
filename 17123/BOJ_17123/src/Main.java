import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int T;
    private int N;
    private int M;
    private int[] rowSum;
    private int[] colSum;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            rowSum = new int[N + 1];
            colSum = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    int input = Integer.parseInt(st.nextToken());
                    rowSum[i] += input;
                    colSum[j] += input;
                }
            }

            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());
                int r1 = Integer.parseInt(st.nextToken());
                int c1 = Integer.parseInt(st.nextToken());
                int r2 = Integer.parseInt(st.nextToken());
                int c2 = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                for (int r = r1; r <= r2; r++) {
                    rowSum[r] += (c2 - c1 + 1) * v;
                }

                for (int c = c1; c <= c2; c++) {
                    colSum[c] += (r2 - r1 + 1) * v;
                }
            }

            for (int i = 1; i <= N; i++) {
                sb.append(rowSum[i] + " ");
            }

            sb.append('\n');

            for (int i = 1; i <= N; i++) {
                sb.append(colSum[i] + " ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
