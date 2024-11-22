import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N / 2; i++) {
            sb.append(1).append(" ").append(2).append(" ");
        }

        if (N % 2 == 1) {
            sb.append(3);
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
