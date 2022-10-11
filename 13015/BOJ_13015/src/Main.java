import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < 2 * N - 1; i++) {

            if (i == N - 1) {
                for (int j = 0; j < N - 1; j++) sb.append(" ");
                sb.append('*');
                for (int j = 0; j < N - 2; j++) sb.append(" ");
                sb.append('*');
                for (int j = 0; j < N - 2; j++) sb.append(" ");
                sb.append('*');
            } else if (i == 0 || i == 2 * N - 2) {
                for (int j = 0; j < N; j++) sb.append('*');
                for (int j = 0; j < 2 * N - 3; j++) sb.append(" ");
                for (int j = 0; j < N; j++) sb.append('*');
            } else {
                for (int j = 0; j < (N - 1) - Math.abs(N - 1 - i); j++) sb.append(" ");
                sb.append('*');
                for (int j = 0; j < N - 2; j++) sb.append(" ");
                sb.append('*');
                for (int j = 0; j < 2 * Math.abs((N - 1) - i) - 1; j++) sb.append(" ");
                sb.append('*');
                for (int j = 0; j < N - 2; j++) sb.append(" ");
                sb.append('*');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
