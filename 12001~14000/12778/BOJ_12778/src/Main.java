import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private int N;
    private char op;

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            op = st.nextToken().charAt(0);

            st = new StringTokenizer(br.readLine());
            if (op == 'N') {
                for (int i = 0; i < N; i++) {
                    int val = Integer.parseInt(st.nextToken());
                    sb.append((char) ('A' + val - 1)).append(" ");
                }
            } else if (op == 'C') {
                for (int i = 0; i < N; i++) {
                    char ch = st.nextToken().charAt(0);
                    sb.append(ch - 'A' + 1).append(" ");
                }
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
