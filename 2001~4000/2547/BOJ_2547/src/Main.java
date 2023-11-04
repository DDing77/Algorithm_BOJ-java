import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int T;
    int N;
    long sum;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            br.readLine();

            sum = 0L;
            N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                sum += Long.parseLong(br.readLine()) % N;
            }

            if (sum % N == 0) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
