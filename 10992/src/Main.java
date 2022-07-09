import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        if (N == 1) System.out.println('*');
        else {
            for (int i = 1; i <= N; i++) {
                for (int j = i; j < N; j++) sb.append(" ");
                if (i == 1) sb.append('*');
                else {
                    if (i == N) for (int j = 0; j < 2 * N - 1; j++) sb.append('*');
                    else {
                        sb.append('*');
                        for (int j = 0; j < 2 * i - 3; j++) sb.append(" ");
                        sb.append('*');
                    }
                }
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
}