import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder bw = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] S = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) S[i] = Integer.parseInt(st.nextToken());
        int[] A = new int[N]; // 이전 원소와의 차이 수열
        A[0] = S[0];
        for (int i = 1; i < N; i++) A[i] = S[i] - S[i - 1];
        RSQ q = new RSQ(A);
        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int o = Integer.parseInt(st.nextToken());
            if (o == 1) {
                int L = Integer.parseInt(st.nextToken()) - 1;
                int R = Integer.parseInt(st.nextToken()) - 1;
                q.update(L, R, 1);
                q.update(R + 1, R + 1, -(R - L + 1));
            } else {
                bw.append(q.query(0, Integer.parseInt(st.nextToken()) - 1)).append("\n");
            }
        }
        System.out.print(bw);
    }

}
class RSQ {
    int n;
    long[] range; long[] lazy;

    RSQ(int[] array) {
        n = array.length;
        range = new long[4 * n];
        lazy = new long[4 * n];
        init(array, 1, 0, n - 1);
    }

    long init(int[] array, int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) return range[node] = array[nodeLeft];
        int mid = (nodeLeft + nodeRight) / 2;
        return range[node] = init(array, 2 * node, nodeLeft, mid) + init(array, 2 * node + 1, mid + 1, nodeRight);
    }

    long query(int left, int right) {
        return query(left, right, 1, 0, n - 1);
    }

    long query(int left, int right, int node, int nodeLeft, int nodeRight) {
        propagate(node, nodeLeft, nodeRight);
        if (right < nodeLeft || nodeRight < left) return 0;
        if (left <= nodeLeft && nodeRight <= right) return range[node];
        int mid = (nodeLeft + nodeRight) / 2;
        return query(left, right, 2 * node, nodeLeft, mid) + query(left, right, 2 * node + 1, mid + 1, nodeRight);
    }

    void update(int left, int right, int k) {
        update(left, right, k, 1, 0, n - 1);
    }

    void update(int left, int right, int k, int node, int nodeLeft, int nodeRight) {
        propagate(node, nodeLeft, nodeRight);
        if (right < nodeLeft || nodeRight < left) return;
        if (left <= nodeLeft && nodeRight <= right) {
            lazy[node] += k;
            propagate(node, nodeLeft, nodeRight);
            return;
        }
        int mid = (nodeLeft + nodeRight) / 2;
        update(left, right, k, 2 * node, nodeLeft, mid);
        update(left, right, k, 2 * node + 1, mid + 1, nodeRight);
        range[node] = range[2 * node] + range[2 * node + 1];
    }

    void propagate(int node, int nodeLeft, int nodeRight) {
        if (lazy[node] != 0) {
            if (nodeLeft != nodeRight) {
                lazy[2 * node] += lazy[node];
                lazy[2 * node + 1] += lazy[node];
            }
            range[node] += lazy[node] * (nodeRight - nodeLeft + 1);
            lazy[node] = 0;
        }
    }

}