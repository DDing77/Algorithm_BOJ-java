import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] tree;
    static int[] lazy;

    static void propagate(int left, int right, int nodeNum) {
        if (lazy[nodeNum] == 0) return;
        if (lazy[nodeNum] % 2 == 1) {
            tree[nodeNum] = (right - left + 1) - tree[nodeNum];
        }
        if (left != right) {
            lazy[nodeNum * 2] += lazy[nodeNum];
            lazy[nodeNum * 2 + 1] += lazy[nodeNum];
        }
        lazy[nodeNum] = 0;
    }

    static void updateTD(int left, int right, int queryLeft, int queryRight, int nodeNum) {
        propagate(left, right, nodeNum);
        if (queryLeft > right || queryRight < left) return;
        if (queryLeft <= left && right <= queryRight) {
            lazy[nodeNum]++;
            propagate(left, right, nodeNum);
            return;
        }

        int mid = (left + right) / 2;
        updateTD(left, mid, queryLeft, queryRight, nodeNum * 2);
        updateTD(mid + 1, right, queryLeft, queryRight, nodeNum * 2 + 1);

        tree[nodeNum] = tree[nodeNum * 2] + tree[nodeNum * 2 + 1];

    }

    static int queryTD(int left, int right, int queryLeft, int queryRight, int nodeNum) {
        propagate(left, right, nodeNum);
        if (queryLeft > right || queryRight < left) return 0;
        if (queryLeft <= left && right <= queryRight) {
            return tree[nodeNum];
        }

        int mid = (left + right) / 2;
        return queryTD(left, mid, queryLeft, queryRight, nodeNum * 2) + queryTD(mid + 1, right, queryLeft, queryRight, nodeNum * 2 + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int startLeaf = 1;
        while (startLeaf < N) startLeaf *= 2;
        int length = startLeaf * 2;

        tree = new int[length + 1];
        lazy = new int[length + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 0) {
                updateTD(1, N, b, c, 1);
            } else {
                sb.append(queryTD(1, N, b, c, 1)).append('\n');
            }
        }
        System.out.print(sb);
    }
}
