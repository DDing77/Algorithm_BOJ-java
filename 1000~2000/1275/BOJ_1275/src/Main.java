import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, Q;
    static long[] tree;
    static int[] arr;

    static void initTD(int start, int end, int nodeNum) {
        if (start == end) {
            tree[nodeNum] = arr[start];
            return;
        }

        int mid = (start + end) >> 1;

        initTD(start, mid, nodeNum * 2);
        initTD(mid + 1, end, nodeNum * 2 + 1);

        tree[nodeNum] = tree[nodeNum * 2] + tree[nodeNum * 2 + 1];
        return;
    }

    static long updateTD(int start, int end, int target, int value, int nodeNum) {
        if (target < start || target > end) return tree[nodeNum];

        if (start == end) return tree[nodeNum] = value;

        int mid = (start + end) >> 1;

        return tree[nodeNum] = updateTD(start, mid, target, value, nodeNum * 2) +
                updateTD(mid + 1, end, target, value, nodeNum * 2 + 1);
    }

    static long queryTD(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryLeft > end || queryRight < start) return 0;
        if (queryLeft <= start && end <= queryRight) return tree[nodeNum];

        int mid = (start + end) >> 1;

        return queryTD(start, mid, queryLeft, queryRight, nodeNum * 2) +
                queryTD(mid + 1, end, queryLeft, queryRight, nodeNum * 2 + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int startLeaf = 1;
        while (startLeaf < N) startLeaf *= 2;
        int length = startLeaf * 2;

        tree = new long[length + 1];
        initTD(1, N, 1);

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int queryLeft = Integer.parseInt(st.nextToken());
            int queryRight = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            if (queryLeft > queryRight) {
                int temp = queryRight;
                queryRight = queryLeft;
                queryLeft = temp;
            }


            sb.append(queryTD(1, N, queryLeft, queryRight, 1)).append('\n');
            updateTD(1, N, target, value, 1);
        }

        System.out.print(sb);

//        System.out.println(Arrays.toString(tree));
    }
}
