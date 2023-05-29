import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static long[] Node;
    static long[] sumTree;
    static long[] lazy;

    static long initTD(int left, int right, int nodeNum) {
        if (left == right) return sumTree[nodeNum] = Node[left];

        int mid = (left + right) / 2;
        return sumTree[nodeNum] = initTD(left, mid, nodeNum * 2) + initTD(mid + 1, right, nodeNum * 2 + 1);
    }

    static void propagate(int left, int right, int nodeNum) {
        if (lazy[nodeNum] != 0) {
            if (left != right) {
                lazy[nodeNum * 2] += lazy[nodeNum];
                lazy[nodeNum * 2 + 1] += lazy[nodeNum];
            }
            sumTree[nodeNum] += lazy[nodeNum] * (right - left + 1);
            lazy[nodeNum] = 0;
        }
    }

    static void updateTD(int left, int right, int queryLeft, int queryRight, int nodeNum, long k) {
        propagate(left, right, nodeNum);
        if (left > queryRight || right < queryLeft) return;
        if (queryLeft <= left && right <= queryRight) {
            lazy[nodeNum] = k;
            propagate(left, right, nodeNum);
            return;
        }

        int mid = (left + right) / 2;
        updateTD(left, mid, queryLeft, queryRight, nodeNum * 2, k);
        updateTD(mid + 1, right, queryLeft, queryRight, nodeNum * 2 + 1, k);

        sumTree[nodeNum] = sumTree[nodeNum * 2] + sumTree[nodeNum * 2 + 1];
    }

    static long queryTD(int left, int right, int queryLeft, int queryRight, int nodeNum) {
        propagate(left, right, nodeNum);
        if (queryRight < left || queryLeft > right) return 0;
        if (queryLeft <= left && right <= queryRight) return sumTree[nodeNum];

        int mid = (left + right) / 2;
        return queryTD(left, mid, queryLeft, queryRight, nodeNum * 2) + queryTD(mid + 1, right, queryLeft, queryRight, nodeNum * 2 + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int startLeaf = 1;
        while (startLeaf < N) startLeaf *= 2;
        int len = startLeaf * 2;

        Node = new long[N + 1];
        sumTree = new long[len + 1];
        lazy = new long[len + 1];

        for (int i = 1; i <= N; i++) {
            Node[i] = Long.parseLong(br.readLine());
        }

        initTD(1, N, 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 1) {
                int queryLeft = Integer.parseInt(st.nextToken());
                int queryRight = Integer.parseInt(st.nextToken());
                long k = Long.parseLong(st.nextToken());
                updateTD(1, N, queryLeft, queryRight, 1, k);
            } else {
                int queryLeft = Integer.parseInt(st.nextToken());
                int queryRight = Integer.parseInt(st.nextToken());
                sb.append(queryTD(1, N, queryLeft, queryRight, 1)).append('\n');
            }
        }
        System.out.print(sb);
    }
}
