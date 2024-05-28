import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private int res;

    private void solution() throws IOException {

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            while (N >= 10) {
                res = 0;
                while (N > 0) {
                    res += N % 10;
                    N /= 10;
                }
                N = res;
            }
            sb.append(N).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
