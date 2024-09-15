import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        if (N % 2 == 0) {
            sb.append("I LOVE CBNU");
        } else {
            for (int i = 0; i < N; i++) {
                sb.append("*");
            }
            sb.append('\n');

            int length = Math.round(N / 2) + 1;
            for (int i = 0; i < length; i++) {
                if (i == 0) {
                    for (int j = 0; j < N / 2; j++) {
                        sb.append(" ");
                    }
                    sb.append('*').append('\n');
                } else {
                    int spaceLength;
                    if (i == 1) {
                        spaceLength = i;
                    } else {
                        spaceLength = i * 2 - 1;
                    }

                    for (int j = 0; j < N / 2 - i; j++) {
                        sb.append(" ");
                    }
                    sb.append("*");
                    for (int j = 0; j < spaceLength; j++) {
                        sb.append(" ");
                    }
                    sb.append("*").append('\n');
                }
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
