import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private int N;
    private int[] heights;
    private int resCnt;

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            heights = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }

            resCnt = 0;
            for (int i = 0; i < N - 1; i++) {
                if (heights[i] >= heights[i + 1]) {
                    resCnt++;
                }
            }

            sb.append("Case #" + tc + ": " + resCnt + "\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
