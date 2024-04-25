import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    int N;
    int K;
    int P;
    int res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        res = 0;
        int count = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * K; i++) {
            if (i % K == 0) {
                count = 0;
            }
            int cur = Integer.parseInt(st.nextToken());
            if (cur == 0) {
                count++;
            }
            if ((i + 1) % K == 0 && count < P) {
                res++;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
