import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int K;
    private int[] numbers;
    private int[] nodeTree;
    private long res;

    private void update(int start, int end, int idx, int value, int nodeNum) {
        if (idx < start || idx > end) {
            return;
        }

        nodeTree[nodeNum] += value;

        if (start == end) {
            return;
        }

        int mid = (start + end) >> 1;
        update(start, mid, idx, value, nodeNum * 2);
        update(mid + 1, end, idx, value, nodeNum * 2 + 1);
    }

    private int query(int start, int end, int cnt, int nodeNum) {
        if (start == end) {
            return start;
        }

        int mid = (start + end) >> 1;
        if (nodeTree[nodeNum * 2] >= cnt) {
            return query(start, mid, cnt, nodeNum * 2);
        } else {
            return query(mid + 1, end, cnt - nodeTree[nodeNum * 2], nodeNum * 2 + 1);
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        numbers = new int[N + 1];
        nodeTree = new int[65535 * 4];
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            update(0, 65535, numbers[i], 1, 1);
            if (i >= K) {
                res += query(0, 65535, (K + 1) / 2, 1);
                update(0, 65535, numbers[i - K + 1], -1, 1);
            }
        }

        System.out.print(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
