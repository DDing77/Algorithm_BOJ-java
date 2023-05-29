import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] taste;
    static int res = Integer.MAX_VALUE;

    static void backTracking(int idx, int sour, int bitter, int bitmask) {
        if (idx == N) {
            if (bitmask == 0) return;
            res = Math.min(res, Math.abs(sour - bitter));
            return;
        }

        for (int i = idx; i < N; i++) {
            backTracking(i + 1, sour * taste[i][0], bitter + taste[i][1], bitmask | (1 << i));
            backTracking(i + 1, sour, bitter, bitmask);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        taste = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            taste[i][0] = Integer.parseInt(st.nextToken());
            taste[i][1] = Integer.parseInt(st.nextToken());
        }

        backTracking(0, 1, 0, 0);

        System.out.println(res);
    }
}
