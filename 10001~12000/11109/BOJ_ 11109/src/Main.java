import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int T;
    int d;
    int n;
    int s;
    int p;

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());

            int parallel = d + n * p;
            int single = n * s;

            if (parallel < single) {
                sb.append("parallelize");
            } else if (parallel > single) {
                sb.append("do not parallelize");
            } else {
                sb.append("does not matter");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
