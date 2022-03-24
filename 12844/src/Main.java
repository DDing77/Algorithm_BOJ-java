import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] tree;
    static int[] lazy;
    static int[] arr;

    static int initTD(int left, int right, int nodeNum) {
        if (left == right) return tree[nodeNum] = arr[left];

        int mid = (left + right) / 2;
        return tree[nodeNum] = initTD(left, mid, nodeNum * 2) ^
                initTD(mid + 1, right, nodeNum * 2 + 1);
    }

    static void propagate(int left, int right, int nodeNum) {
        if (lazy[nodeNum] != 0) {
            if (left != right) {
                lazy[nodeNum * 2] ^= lazy[nodeNum];
                lazy[nodeNum * 2 + 1] ^= lazy[nodeNum];
            }
            if ((right - left + 1) % 2 == 1) {
                tree[nodeNum] ^= lazy[nodeNum];
            }
            lazy[nodeNum] = 0;
        }
    }

    static void updateTD(int left, int right, int queryLeft, int queryRight, int nodeNum, int k) {
        propagate(left, right, nodeNum);
        if (queryLeft > right || queryRight < left) return;
        if (queryLeft <= left && right <= queryRight) {
            lazy[nodeNum] = k;
            propagate(left, right, nodeNum);
            return;
        }

        int mid = (left + right) / 2;
        updateTD(left, mid, queryLeft, queryRight, nodeNum * 2, k);
        updateTD(mid + 1, right, queryLeft, queryRight, nodeNum * 2 + 1, k);
        tree[nodeNum] = tree[nodeNum * 2] ^ tree[nodeNum * 2 + 1];
    }

    static int queryTD(int left, int right, int queryLeft, int queryRight, int nodeNum) {
        propagate(left, right, nodeNum);
        if (queryLeft > right || queryRight < left) return 0;
        if (queryLeft <= left && right <= queryRight) {
            return tree[nodeNum];
        }
        int mid = (left + right) / 2;
        return queryTD(left, mid, queryLeft, queryRight, nodeNum * 2) ^ queryTD(mid + 1, right, queryLeft, queryRight, nodeNum * 2 + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int startLeaf = 1;
        while (startLeaf < N) startLeaf *= 2;
        int length = startLeaf * 2;

        tree = new int[length + 1];
        lazy = new int[length + 1];

        initTD(1, N, 1);
//        System.out.println(Arrays.toString(tree));

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int opr = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken()) + 1;
            int b = Integer.parseInt(st.nextToken()) + 1;

            if (opr == 1) {
                int k = Integer.parseInt(st.nextToken());
                updateTD(1, N, a, b, 1, k);
            } else {
                sb.append(queryTD(1, N, a, b, 1)).append('\n');
            }
        }
        System.out.print(sb);
    }
}
