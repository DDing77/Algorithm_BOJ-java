import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private int N, K;
    private int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        res = 1;
        int cur;
        int max;
        for (int i = 2; i <= N; i++) {
            cur = i;
            max = 0;
            for (int j = 2; j <= Math.sqrt(cur); j++) {
                while (cur % j == 0) {
                    cur /= j;
                    max = j;
                }
            }

            if (cur != 1) max = cur;
            if (max <= K) res++;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
