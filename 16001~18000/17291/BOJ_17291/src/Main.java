import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private static final int LENGTH = 21;

    private int N;
    private int[] alive;
    private int[] death;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        alive = new int[LENGTH];
        death = new int[LENGTH];

        alive[1] = 1;
        death[4] = 1;

        for (int i = 2; i <= N; i++) {
            int cache = alive[i - 1];
            alive[i] = cache * 2 - death[i];

            if ((i & 1) == 1) {
                if (i + 3 <= N) {
                    death[i + 3] += cache;
                }
            } else {
                if (i + 4 <= N) {
                    death[i + 4] += cache;
                }
            }
        }

        System.out.println(alive[N]);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
