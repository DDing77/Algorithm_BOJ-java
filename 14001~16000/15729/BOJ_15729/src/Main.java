import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private boolean[] plaintext;
    private boolean[] ciphertext;
    private int res;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        plaintext = new boolean[N];
        ciphertext = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (input == 1) {
                plaintext[i] = true;
            }
        }

        for (int i = 0; i < N; i++) {
            if (plaintext[i] != ciphertext[i]) {
                res++;
                for (int j = i; j < i + 3; j++) {
                    if (j >= N) {
                        continue;
                    }
                    ciphertext[j] = !ciphertext[j];
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
