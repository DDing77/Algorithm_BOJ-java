import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int[] instructions;
    private int res;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        instructions = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            instructions[i] = Integer.parseInt(br.readLine());
        }

        int cur = 1;
        while (M-- > 0) {
            res++;

            cur += Integer.parseInt(br.readLine());
            if (cur >= N) {
                break;
            }

            cur += instructions[cur];
            if (cur >= N) {
                break;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
