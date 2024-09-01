import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private int[] A;

    private boolean check(int idx) {

        for (int i = 1; idx - 2 * i >= 0; i++) {
            if (A[idx] == A[idx - i] * 2 - A[idx - 2 * i]) {
                return false;
            }
        }

        return true;
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        if (N < 2) {
            System.out.println(1);
        } else {
            A = new int[N + 1];
            A[0] = 1;
            A[1] = 1;

            for (int i = 2; i <= N; i++) {
                for (int j = 1; ; j++) {
                    A[i] = j;
                    if (check(i)) {
                        break;
                    }
                }
            }

            System.out.println(A[N]);
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
