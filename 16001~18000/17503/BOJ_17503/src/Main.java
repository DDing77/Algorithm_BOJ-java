import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int K;
    private int[][] beers;
    private PriorityQueue<int[]> pq;

    private boolean check(long level) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int[] beer : beers) {
            if (beer[1] <= level) {
                pq.add(beer[0]);
            }
        }

        if (pq.size() < N) {
            return false;
        }

        int sum = 0;
        int cnt = N;
        while (cnt-- > 0) {
            sum += pq.poll();
        }

        if (sum >= M) {
            return true;
        }

        return false;
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        beers = new int[K][2];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            beers[i][0] = Integer.parseInt(st.nextToken());
            beers[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(beers, Comparator.comparingInt(a -> a[1]));

        long left = 0;
        long right = Integer.MAX_VALUE;

        if (!check(right)) {
            System.out.println(-1);
            return;
        }

        while (left + 1 < right) {
            long mid = (left + right) >> 1;
            if (check(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        System.out.println(right);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
