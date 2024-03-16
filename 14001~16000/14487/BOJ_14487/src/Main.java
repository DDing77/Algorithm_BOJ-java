import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int[] costs;
    int res;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        costs = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        int res = Integer.MAX_VALUE;
        int windowSize = 0;
        int left = 0;
        int right = 0;
        int sum = 0;

        while (windowSize < N - 1) {
            sum += costs[right++];
            windowSize++;
        }
        res = Math.min(res, sum);

        while (left < N) {

            sum += costs[right % N];
            right++;
            sum -= costs[left++];
            res = Math.min(res, sum);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
