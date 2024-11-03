import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;

    private void solution() throws IOException {

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            sb.append(N).append(" ");

            while (N / 10 != 0) {
                int res = 1;
                int tmp = N;
                while (tmp > 0) {
                    res *= tmp % 10;
                    tmp /= 10;
                }
                sb.append(res).append(" ");
                N = res;
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

