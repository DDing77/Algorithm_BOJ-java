import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Info {
        long l;
        long r;

        public Info() {

        }

        public Info(long l, long r) {
            this.l = l;
            this.r = r;
        }
    }

    static Info[] tree;

    static int N, K;
    static long[] x;
    static long[] y;
    static int bias;
    static int LogN;
    static PriorityQueue<Long> pq;
    static long h;

    static void getLogN() {
        LogN = 0;
        for (int k = 1; k < N; k *= 2) LogN++;
    }

    static void initBU() {
        for (int i = 0; i < N; i++) {
            tree[i | bias].l = y[i];
            tree[i | bias].r = i;
        }
        for (int i = bias - 1; i > 0; i--) {
            tree[i] = tree[i << 1].l < tree[i << 1 | 1].l ? tree[i << 1] : tree[i << 1 | 1];
        }
    }

    static long f(int start, int end) {
        if (start >= end) return 0;

        int idx = (int) query(start, end - 1);
        long pre = h;
        h = y[idx];

        long t1 = f(start, idx);
        long t2 = f(idx + 1, end);
        pq.add(Math.min(t1, t2));
        h = pre;
        return Math.max(t1, t2) + (x[end] - x[start]) * (y[idx] - h);
    }

    static long query(int left, int right) {
        left |= bias;
        right |= bias;
        Info temp = new Info((long) 1e18, (long) 1e18);
        while (left <= right) {
            if ((left & 1) > 0) {
                temp = temp.l < tree[left].l ? temp : tree[left];
                left++;
            }
            if (((~right) & 1) > 0) {
                temp = temp.l < tree[right].l ? temp : tree[right];
                right--;
            }
            left >>= 1;
            right >>= 1;
        }

        return temp.r;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
//        getLogN();
        N >>= 1;

        tree = new Info[1 << 19];
        for (int i = 0; i < (1 << 19); i++) tree[i] = new Info();
        x = new long[1 << 18];
        y = new long[1 << 18];
        bias = 1 << 18;
        pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
            st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }

        K = Integer.parseInt(br.readLine());

        initBU();

        long t = f(0, N - 1);
        pq.add(t);

        long res = 0;
        for (int i = 0; i < K; i++) {
            if (pq.size() == 0) break;
            res += pq.poll();
//            System.out.println("test res : " + res);
        }

        System.out.println(res);
    }

}
