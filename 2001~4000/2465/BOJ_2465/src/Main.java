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
    private int[] numbers;
    private int[] nodeTree;
    private int[] counts;
    private int[] res;

    private void init(int start, int end, int nodeNum) {
        if (start == end) {
            nodeTree[nodeNum] = 1;
            return;
        }

        int mid = (start + end) >> 1;
        init(start, mid, nodeNum << 1);
        init(mid + 1, end, nodeNum << 1 | 1);
        nodeTree[nodeNum] = nodeTree[nodeNum << 1] + nodeTree[nodeNum << 1 | 1];
    }

    private int query(int start, int end, int count, int nodeNum) {
        if (start == end) {
            return start;
        }

        int mid = (start + end) >> 1;
        if (count <= nodeTree[nodeNum << 1]) {
            return query(start, mid, count, nodeNum << 1);
        } else {
            return query(mid + 1, end, count - nodeTree[nodeNum << 1], nodeNum << 1 | 1);
        }
    }

    private void update(int start, int end, int targetIdx, int nodeNum) {
        if (targetIdx < start || end < targetIdx) {
            return;
        }

        nodeTree[nodeNum]--;

        if (start == end) {
            return;
        }

        int mid = (start + end) >> 1;
        update(start, mid, targetIdx, nodeNum << 1);
        update(mid + 1, end, targetIdx, nodeNum << 1 | 1);
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N + 1];
        numbers[0] = 0;
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);

        counts = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            counts[i] = Integer.parseInt(st.nextToken());
        }

        nodeTree = new int[N * 4];
        init(1, N, 1);

        res = new int[N + 1];
        for (int i = N; i >= 1; i--) {
            int idx = query(1, N, counts[i] + 1, 1);
            res[i] = numbers[idx];
            update(1, N, idx, 1);
        }
        // 0 119 120 120 134 145 155 156 163 167 167 172 182
        for (int i = 1; i <= N; i++) {
            sb.append(res[i]).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
