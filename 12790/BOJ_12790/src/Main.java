import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int[] state;
    static int res;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            state = new int[4];

            for (int i = 0; i < 8; i++) {
                state[i % 4] += Integer.parseInt(st.nextToken());
            }

            res = 0;
            for (int i = 0; i < 2; i++) {
                state[i] = Math.max(state[i], 1);
            }
            res = state[0];
            res += 5 * state[1];

            state[2] = Math.max(state[2], 0);
            res += 2 * (state[2] + state[3]);

            sb.append(res).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
