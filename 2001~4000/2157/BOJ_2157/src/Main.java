import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int[][] dp;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[M + 1][N + 1];
        for (int i = 0; i <= M; i++) Arrays.fill(dp[i], -1);
        dp[1][1] = 0;

        List<City>[] edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) edges[i] = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a >= b) {
                continue;
            }
            edges[a].add(new City(b, c));
        }

        Deque<Integer> q = new ArrayDeque<>();
        q.add(1);
        int cities = 1;

        while (!q.isEmpty() && cities < M) {
            int size = q.size();
            while (size-- > 0) {
                int now = q.poll();
                if (dp[cities][now] == -1) {
                    continue;
                }
                for (City edge : edges[now]) {
                    int next = edge.number;
                    int cand = dp[cities][now] + edge.value;
                    if (dp[cities + 1][next] >= cand) {
                        continue;
                    }
                    dp[cities + 1][next] = cand;
                    q.add(next);
                }
            }
            cities++;
        }

        int answer = 0;
        for (int usedCities = 2; usedCities <= M; usedCities++) {
            answer = Math.max(answer, dp[usedCities][N]);
        }

        sb.append(answer);
        System.out.println(sb);
    }

    private static class City {
        int number, value;

        City(int number, int value) {
            this.number = number;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
