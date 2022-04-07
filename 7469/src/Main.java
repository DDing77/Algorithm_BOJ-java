import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int[][] tree;

    static void init(int start, int end, int nodeNum) {
        if (start == end) tree[nodeNum] = new int[]{arr[start]};
        else {
            int mid = (start + end) >> 1;
            init(start, mid, nodeNum * 2);
            init(mid + 1, end, nodeNum * 2 + 1);
            merge(start, end, nodeNum);
        }
    }

    static void merge(int start, int end, int nodeNum) {
        tree[nodeNum] = new int[end - start + 1];
        int l = start;
        int mid = (start + end) >> 1;
        int r = mid + 1;
        int idx = 0;
        while (l <= mid && r <= end) {
            if (arr[l] < arr[r]) tree[nodeNum][idx++] = arr[l++];
            else tree[nodeNum][idx++] = arr[r++];
        }
        while (l <= mid) tree[nodeNum][idx++] = arr[l++];
        while (r <= end) tree[nodeNum][idx++] = arr[r++];

        for (int i = start; i <= end; i++) arr[i] = tree[nodeNum][i - start];
    }

    static int query(int start, int end, int queryLeft, int queryRight, int nodeNum, int k) {
        if (start > queryRight || end < queryLeft) return 0;
        if (queryLeft <= start && end <= queryRight) {
            return lowerBound(nodeNum, k);

        }
        int mid = (start + end) >> 1;
        return query(start, mid, queryLeft, queryRight, nodeNum * 2, k) +
                query(mid + 1, end, queryLeft, queryRight, nodeNum * 2 + 1, k);
    }

    static int lowerBound(int nodeNum, int k) {
        int left = 0;
        int right = tree[nodeNum].length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (tree[nodeNum][mid] >= k) right = mid;
            else left = mid + 1;
        }
        return right;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int startLeaf = 1;
        while (startLeaf < N) startLeaf *= 2;
        int length = startLeaf * 2;

        tree = new int[length + 1][];
        init(1, N, 1);

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int left = -1_000_000_001;
            int right = 1_000_000_001;
            while (left <= right) {
                int mid = (left + right) >> 1;
                int res = query(1, N, i, j, 1, mid);
                if (res < k) {
                    left = mid + 1;
                } else right = mid - 1;
            }
            sb.append(right).append('\n');
        }
        System.out.print(sb);
    }
}