import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int K;
    int N;
    long res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        if (N == 1) {
            System.out.println(-1);
            return;
        }

        res = ((long) K * N) / (N - 1);

        if ((long) K * N % (N - 1) != 0) {
            res++;
        }

        System.out.println(res);

    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
