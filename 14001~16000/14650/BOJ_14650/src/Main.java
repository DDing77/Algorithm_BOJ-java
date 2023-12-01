import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    final int[] numbers = {0, 1, 2};
    int N;
    int[] selected;
    int res;

    public void backTracking(int depth) {
        if (depth == N) {
            int num = 0;
            for (int i = 0; i < N; i++) {
                num *= 10;
                num += selected[i];
            }
            if (num % 3 == 0) {
                res++;
            }
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (i == 0 && depth == 0) {
                continue;
            }
            selected[depth] = i;
            backTracking(depth + 1);
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        res = 0;
        selected = new int[N];
        backTracking(0);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
