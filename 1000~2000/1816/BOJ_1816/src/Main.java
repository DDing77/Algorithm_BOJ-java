import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            long input = Long.parseLong(br.readLine());
            boolean flag = true;
            for (int j = 2; j <= 1_000_000; j++) {
                if (input % j == 0) {
                    sb.append("NO").append('\n');
                    flag = false;
                    break;
                }
            }

            if (flag) {
                sb.append("YES").append('\n');
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
