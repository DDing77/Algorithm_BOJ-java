import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private String input;

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("Case " + tc + ": ");
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            String op = st.nextToken();
            int B = Integer.parseInt(st.nextToken());
            String equal = st.nextToken();
            int C = Integer.parseInt(st.nextToken());

            if (op.equals("+")) {
                if (A + B == C) {
                    sb.append("YES");
                } else {
                    sb.append("NO");
                }
            } else if (op.equals("-")) {
                if (A - B == C) {
                    sb.append("YES");
                } else {
                    sb.append("NO");
                }
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
