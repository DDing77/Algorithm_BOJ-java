import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private int L;
    private int R;
    private int S;

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());

            int left = Math.abs(L - S) * 2 + 1;
            int right = Math.abs(R - S) * 2;
            sb.append(Math.min(left, right)).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
