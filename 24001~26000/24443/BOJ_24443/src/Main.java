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
    private int[] arrRank;
    private int[] rankToVal;
    private int B;
    private int NB;
    private int[][] buckets;
    private int[] bL, bR;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        int[][] pairs = new int[N][2];
        for (int i = 0; i < N; i++) {
            pairs[i][0] = A[i];
            pairs[i][1] = i;
        }
        Arrays.sort(pairs, (x, y) -> Integer.compare(x[0], y[0]));

        rankToVal = new int[N + 1];
        arrRank = new int[N];
        for (int r = 1; r <= N; r++) {
            rankToVal[r] = pairs[r - 1][0];
            arrRank[pairs[r - 1][1]] = r;
        }

        B = (int) Math.sqrt(N) + 1;
        NB = (N + B - 1) / B;
        bL = new int[NB];
        bR = new int[NB];
        buckets = new int[NB][];

        for (int b = 0; b < NB; b++) {
            bL[b] = b * B;
            bR[b] = Math.min(N - 1, (b + 1) * B - 1);
            rebuildBlock(b);
        }

        for (int qi = 0; qi < Q; qi++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;

            if (type == 1) {
                int k = Integer.parseInt(st.nextToken());
                int rank = kthInRange(i, j, k);
                sb.append(rankToVal[rank]).append('\n');
            } else {
                if (i != j) swapAndRebuild(i, j);
            }
        }

        System.out.print(sb);
    }

    private int kthInRange(int l, int r, int k) {
        int lo = 1, hi = N;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            int cnt = countLE(l, r, mid);
            if (cnt >= k) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private int countLE(int l, int r, int x) {
        int lb = l / B, rb = r / B;
        int cnt = 0;

        if (lb == rb) {
            for (int p = l; p <= r; p++) if (arrRank[p] <= x) cnt++;
            return cnt;
        }

        int endL = bR[lb];
        for (int p = l; p <= endL; p++) if (arrRank[p] <= x) cnt++;

        for (int b = lb + 1; b <= rb - 1; b++) {
            int[] bucket = buckets[b];
            cnt += upperBound(bucket, x);
        }

        int startR = bL[rb];
        for (int p = startR; p <= r; p++) if (arrRank[p] <= x) cnt++;

        return cnt;
    }

    private void swapAndRebuild(int i, int j) {
        int bi = i / B, bj = j / B;
        int tmp = arrRank[i];
        arrRank[i] = arrRank[j];
        arrRank[j] = tmp;

        if (bi == bj) {
            rebuildBlock(bi);
        } else {
            rebuildBlock(bi);
            rebuildBlock(bj);
        }
    }

    private void rebuildBlock(int b) {
        int l = bL[b], r = bR[b];
        int len = r - l + 1;
        int[] buf = new int[len];
        for (int i = 0; i < len; i++) buf[i] = arrRank[l + i];
        Arrays.sort(buf);
        buckets[b] = buf;
    }

    private int upperBound(int[] a, int key) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (a[mid] <= key) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
