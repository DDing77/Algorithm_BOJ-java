import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[] tree;

    static long getCnt(int x) {
        x++;
        long res = 0;
        while (x > 0) {
            res += tree[x];
            x -= x & -x;
        }
        return res;
    }

    static void update(int x, long val) {
        x++;
        while (x < 100010) {
            tree[x] += val;
            x += x & -x;
        }
    }

    static void makeHoriz(int left, int right, int val) {
        update(left, val);
        update(right + 1, -val);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        tree = new long[100010];

        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            long a = getCnt(L);
            long b = getCnt(R);

            update(L, -a);
            update(L + 1, a);
            update(R, -b);
            update(R + 1, b);
            makeHoriz(L + 1, R - 1, 1);
            sb.append(a + b).append('\n');
        }
        System.out.print(sb);
    }
}
