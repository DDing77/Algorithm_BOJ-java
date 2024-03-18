import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int R;
    int B;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        for (int i = (int) Math.sqrt(B); i >= 1; i--) {
            if (R == (i * 2 + 4 + (B / i) * 2)) {
                sb.append(B / i + 2).append(" ").append(i + 2);
                break;
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
