import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int[] lights;
    private int[] nodes;

    private int init(int start, int end, int nodeNum) {
        if (start == end) {
            return nodes[nodeNum] = lights[start];
        }

        int mid = (start + end) >> 1;
        return nodes[nodeNum] = Math.max(init(start, mid, nodeNum * 2), init(mid + 1, end, nodeNum * 2 + 1));
    }

    private int query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryLeft > end || queryRight < start) {
            return 0;
        }

        if (queryLeft <= start && queryRight >= end) {
            return nodes[nodeNum];
        }

        int mid = (start + end) >> 1;
        return Math.max(query(start, mid, queryLeft, queryRight, nodeNum * 2), query(mid + 1, end, queryLeft, queryRight, nodeNum * 2 + 1));
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nodes = new int[N * 4];
        lights = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            lights[i] = Integer.parseInt(st.nextToken());
        }

        init(1, N, 1);

        for (int i = M; i <= N - M + 1; i++) {
            sb.append(query(1, N, i - (M - 1), i + (M - 1), 1)).append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
