import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int MAX = 65536;

    private int N;
    private int K;
    private int[] numbers;
    private int[] nodes;
    private long res;

    private void update(int start, int end, int target, int value, int nodeNum) {
        if (target < start || target > end) {
            return;
        }

        nodes[nodeNum] += value;

        if (start == end) {
            return;
        }

        int mid = (start + end) >> 1;
        update(start, mid, target, value, nodeNum * 2);
        update(mid + 1, end, target, value, nodeNum * 2 + 1);
    }

    private int query(int start, int end, int cnt, int nodeNum) {
        if (start == end) {
            return start;
        }

        int mid = (start + end) >> 1;
        if (cnt <= nodes[nodeNum * 2]) {
            return query(start, mid, cnt, nodeNum * 2);
        } else {
            return query(mid + 1, end, cnt - nodes[nodeNum * 2], nodeNum * 2 + 1);
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nodes = new int[MAX * 4];
        res = 0L;

        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            update(0, MAX, numbers[i], 1, 1);
            if (i >= K - 1) {
                res += query(0, MAX, (nodes[1] + 1) / 2, 1);
                update(0, MAX, numbers[i - K + 1], -1, 1);
            }

        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
