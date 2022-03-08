import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr;
    static long[] dp;

    static class Info {
        int idx;
        long value;

        public Info(int idx, long value) {
            this.idx = idx;
            this.value = value;
        }
    }

    static ArrayList<Info>[] infos;

    static void solution() {
        long sum = 0;
        for (int L = 1, R = 0; L <= N; L++) {
            while (R + 1 <= N && sum < K) sum += arr[++R];

            if(sum >= K) {
                infos[R].add(new Info(L, sum - K));
            }
            sum -= arr[L];
        }

        for(int R = 1; R <=N; R++) {
            dp[R] = dp[R-1];
            for(Info i : infos[R]) {
                dp[R] = Math.max(dp[R], dp[i.idx-1] + i.value );
            }
        }
        System.out.println(dp[N]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        dp = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        infos = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) infos[i] = new ArrayList<>();

        solution();
    }
}
