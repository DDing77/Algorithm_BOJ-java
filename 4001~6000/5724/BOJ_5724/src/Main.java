import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int N;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            res = 0;
            for (int i = 1; i <= N; i++) {
                res += (N - i + 1) * (N - i + 1);
            }

            sb.append(res).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
