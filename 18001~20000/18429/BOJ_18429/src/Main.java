import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int K;
    int[] weights;
    boolean[] isVisited;
    int res;

    private void backTracking(int depth, int cur) {
        if (depth == N) {
            res++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isVisited[i] && (cur + weights[i] - K) >= 500) {
                isVisited[i] = true;
                backTracking(depth + 1, cur + weights[i] - K);
                isVisited[i] = false;
            }
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        weights = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        res = 0;
        isVisited = new boolean[N];
        backTracking(0, 500);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
