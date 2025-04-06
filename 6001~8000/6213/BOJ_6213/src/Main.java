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
    private int Q;
    private int[] numbers;
    private int[] minNode;
    private int[] maxNode;

    private void buildMin(int start, int end, int nodeNum) {
        if (start == end) {
            minNode[nodeNum] = numbers[start];
            return;
        }

        int mid = (start + end) >> 1;
        buildMin(start, mid, nodeNum * 2);
        buildMin(mid + 1, end, nodeNum * 2 + 1);

        if (minNode[nodeNum * 2] < minNode[nodeNum * 2 + 1]) {
            minNode[nodeNum] = minNode[nodeNum * 2];
        } else {
            minNode[nodeNum] = minNode[nodeNum * 2 + 1];
        }
    }

    private void buildMax(int start, int end, int nodeNum) {
        if (start == end) {
            maxNode[nodeNum] = numbers[start];
            return;
        }

        int mid = (start + end) >> 1;
        buildMax(start, mid, nodeNum * 2);
        buildMax(mid + 1, end, nodeNum * 2 + 1);

        if (maxNode[nodeNum * 2] > maxNode[nodeNum * 2 + 1]) {
            maxNode[nodeNum] = maxNode[nodeNum * 2];
        } else {
            maxNode[nodeNum] = maxNode[nodeNum * 2 + 1];
        }
    }

    private int minQuery(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryLeft > end || queryRight < start) {
            return Integer.MAX_VALUE;
        }

        if (queryLeft <= start && end <= queryRight) {
            return minNode[nodeNum];
        }

        int mid = (start + end) >> 1;
        return Math.min(minQuery(start, mid, queryLeft, queryRight, nodeNum * 2),
                minQuery(mid + 1, end, queryLeft, queryRight, nodeNum * 2 + 1));
    }

    private int maxQuery(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryLeft > end || queryRight < start) {
            return Integer.MIN_VALUE;
        }

        if (queryLeft <= start && end <= queryRight) {
            return maxNode[nodeNum];
        }

        int mid = (start + end) >> 1;
        return Math.max(maxQuery(start, mid, queryLeft, queryRight, nodeNum * 2),
                maxQuery(mid + 1, end, queryLeft, queryRight, nodeNum * 2 + 1));
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        int size = 1;
        while (size < N * 2) {
            size <<= 1;
        }

        numbers = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        minNode = new int[size];
        maxNode = new int[size];
        buildMin(1, N, 1);
        buildMax(1, N, 1);

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            int minNumber = minQuery(1, N, left, right, 1);
            int maxNumber = maxQuery(1, N, left, right, 1);
            sb.append(maxNumber - minNumber).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
