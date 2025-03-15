import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] numbers;
    private int[] nodes;
    private long res;

    private void update(int start, int end, int target, int nodeNum) {
        if (target < start || target > end) {
            return;
        }

        nodes[nodeNum]++;

        if (start == end) {
            return;
        }

        int mid = (start + end) >> 1;
        update(start, mid, target, nodeNum * 2);
        update(mid + 1, end, target, nodeNum * 2 + 1);
    }

    private int query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryRight < start || end < queryLeft) {
            return 0;
        }

        if (queryLeft <= start && queryRight >= end) {
            return nodes[nodeNum];
        }

        int mid = (start + end) >> 1;
        return query(start, mid, queryLeft, queryRight, nodeNum * 2)
                + query(mid + 1, end, queryLeft, queryRight, nodeNum * 2 + 1);
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        numbers = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        nodes = new int[N * 4];
        res = 0L;
        for (int i = N; i >= 1; i--) {
            res += query(1, N, 1, numbers[i] - 1, 1);
            update(1, N, numbers[i], 1);
        }

        System.out.print(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
