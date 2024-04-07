import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    private void solution() throws IOException {

        int tc = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            String op = st.nextToken();
            int b = Integer.parseInt(st.nextToken());

            if (op.equals("E")) {
                System.out.print(sb);
                return;
            }

            sb.append("Case ").append(tc++).append(": ");
            if (op.equals("!=")) {
                sb.append(a != b).append("\n");
            } else if (op.equals("<")) {
                sb.append(a < b).append("\n");
            } else if (op.equals(">")) {
                sb.append(a > b).append("\n");
            } else if (op.equals("<=")) {
                sb.append(a <= b).append("\n");
            } else if (op.equals(">=")) {
                sb.append(a >= b).append("\n");
            } else if (op.equals("==")) {
                sb.append(a == b).append("\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}