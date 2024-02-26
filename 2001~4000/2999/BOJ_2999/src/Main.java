import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    String input;
    int R;
    int C;
    int N;

    private void solution() throws IOException {

        input = br.readLine();

        N = input.length();
        R = 1;
        C = N / R;

        for (int i = 1; i <= (int) Math.sqrt(N); i++) {
            if (N % i == 0) {
                R = i;
            }
        }

        C = N / R;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(input.charAt(i + j * R));
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
