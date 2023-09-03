import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int T;
    int N;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            int cnt;
            for (int i = 2; i <= N; i++) {
                cnt = 0;
                while (N % i == 0) {
                    cnt++;
                    N /= i;
                }

                if (cnt != 0) {
                    sb.append(i).append(" ").append(cnt).append('\n');
                }

                if (N == 0) {
                    break;
                }
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
