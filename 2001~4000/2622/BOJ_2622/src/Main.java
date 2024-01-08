import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int N;
    int res;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        res = 0;
        for (int i = 1; i < N; i++) {
            for (int j = i; j <= (N - i) / 2; j++) {
                int k = N - i - j;

                if (k < i + j) {
                    res++;
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
