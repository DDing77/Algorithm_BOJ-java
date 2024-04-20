import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int Q;
    int V;
    int S;
    int[] c;
    int[] t;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        c = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            c[i] -= Integer.parseInt(st.nextToken());
        }

        Arrays.sort(c);
        // -1 3 4 4 6
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());

            int left = -1;
            int right = N - 1;
            while (left + 1 < right) {
                int mid = (left + right) >> 1;
                if (c[mid] > S) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            if (c[right] > S && (N - right) >= V) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
