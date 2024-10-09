import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int Q;
    private char[] S;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        S = br.readLine().toCharArray();

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            if (op == 1) {
                int cnt = 1;
                for (int j = left; j < right; j++) {
                    if (S[j - 1] != S[j]) {
                        cnt++;
                    }
                }
                sb.append(cnt).append('\n');
            } else if (op == 2) {
                for (int j = left - 1; j < right; j++) {
                    S[j] = (char) ('A' + (((S[j] - 'A') + 1) % 26));
                }
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
