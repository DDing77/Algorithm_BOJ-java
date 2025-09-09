import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());

        if (N == 0) {
            System.out.println("0 0");
            return;
        }

        final int INF = 1_000_000_000;
        int[] day = new int[N + 1];
        int[] water = new int[N + 1];
        Arrays.fill(day, INF);
        Arrays.fill(water, INF);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        day[0] = 0;
        water[0] = 0;
        q.add(0);

        while (!q.isEmpty()) {
            int x = q.poll();
            int d = day[x];
            int w = water[x];

            if (x + 1 <= N) {
                relax(x + 1, d + 1, w + 1, day, water, q);
            }

            long mul3 = (long) x * 3L;
            if (mul3 <= N) {
                relax((int) mul3, d + 1, w + 3, day, water, q);
            }

            long sq = (long) x * (long) x;
            if (sq <= N) {
                relax((int) sq, d + 1, w + 5, day, water, q);
            }
        }

        System.out.println(day[N] + " " + water[N]);
    }

    private static void relax(int y, int nd, int nw, int[] day, int[] water, ArrayDeque<Integer> q) {
        if (nd < day[y] || (nd == day[y] && nw < water[y])) {
            day[y] = nd;
            water[y] = nw;
            q.add(y);
        }
    }
}
