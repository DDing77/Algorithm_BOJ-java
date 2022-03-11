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

    static void initTD(int left, int right, int nodeNum) {
        if (left == right) {
            sumTree[nodeNum] = Node[nodeNum];
            return;
        }
        int mid = (left + right) / 2;
        initTD(left, mid, nodeNum * 2);
        initTD(mid + 1, right, nodeNum * 2 + 1);
    }

    static void updateTD(int left, int right, int queryLeft, int queryRight, int nodeNum, long k) {
        if (left > queryRight || right < queryLeft) return;
        if (queryLeft <= left && right <= queryRight) {
            sumTree[nodeNum] += k;
            return;
        }
        int mid = (left + right) / 2;
        updateTD(left, mid, queryLeft, queryRight, nodeNum * 2, k);
        updateTD(mid + 1, right, queryLeft, queryRight, nodeNum * 2 + 1, k);
    }

    static long queryTD(int left, int right, int queryLeft, int queryRight, int nodeNum, long ans) {
        if (queryRight < left || queryLeft > right) return 0;
        ans += sumTree[nodeNum];
        if (left == right) return ans;
        int mid = (left + right) / 2;
        return queryTD(left, mid, queryLeft, queryRight, nodeNum * 2, ans) + queryTD(mid + 1, right, queryLeft, queryRight, nodeNum * 2 + 1, ans);
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

        Node = new long[len + 1];
        sumTree = new long[len + 1];

        for (int i = 0; i < N; i++) {
            Node[startLeaf + i] = Long.parseLong(br.readLine());
        }

        initTD(1, startLeaf, 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 1) {
                int queryLeft = Integer.parseInt(st.nextToken());
                int queryRight = Integer.parseInt(st.nextToken());
                long k = Integer.parseInt(st.nextToken());
                updateTD(1, startLeaf, queryLeft, queryRight, 1, k);
            } else {
                int queryLeft = Integer.parseInt(st.nextToken());
                int queryRight = Integer.parseInt(st.nextToken());
                sb.append(queryTD(1, startLeaf, queryLeft, queryRight, 1, 0)).append('\n');
            }
        }
        System.out.println(sb);
    }
}
