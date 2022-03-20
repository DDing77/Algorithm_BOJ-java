import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] tree;

    static int initTD(int start, int end, int node) {
        if (start == end) {
            return tree[node] = start;
        } else {
            int mid = (start + end) / 2;
            int A = initTD(start, mid, node * 2);
            int B = initTD(mid + 1, end, node * 2 + 1);

            if (arr[A] <= arr[B]) {
                tree[node] = A;
            } else {
                tree[node] = B;
            }
            return tree[node];
        }
    }

    static int query(int left, int right, int queryLeft, int queryRight, int nodeNum) {
        if (left > queryRight || right < queryLeft) return -1;
        if (queryLeft <= left && right <= queryRight) return tree[nodeNum];

        int mid = (left + right) / 2;
        int m1 = query(left, mid, queryLeft, queryRight, nodeNum * 2);
        int m2 = query(mid + 1, right, queryLeft, queryRight, nodeNum * 2 + 1);

        if (m1 == -1) {
            return m2;
        } else if (m2 == -1) {
            return m1;
        } else {
            if (arr[m1] <= arr[m2]) {
                return m1;
            } else {
                return m2;
            }
        }
    }

    public static long getMax(int left, int right, int N) {
        int m = query(1, N, left, right, 1);

        long area = (right - left + 1) * (long) arr[m];

        if (left <= m - 1) {
            long tmp = getMax(left, m - 1, N);

            area = Math.max(area, tmp);
        }

        if (m + 1 <= right) {
            long tmp = getMax(m + 1, right, N);

            area = Math.max(area, tmp);
        }

        return area;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) break;

            arr = new int[N + 1];

            for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

            int startLeaf = 1;
            while (startLeaf < N) startLeaf *= 2;
            int length = startLeaf * 2;

            tree = new int[length + 1];

//            for(int i=0; i<N; i++) tree[startLeaf+i] = i;
            initTD(1, N, 1);
            sb.append(getMax(1, N, N)).append('\n');
//            System.out.println(Arrays.toString(tree));
//            System.out.println(query(1, N, 3, 4, 1));
//            System.out.println("test");
        }
        System.out.print(sb);
    }
}
