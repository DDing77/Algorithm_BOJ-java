import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int sum = 0;

        for (int i = 0; i <= N; i++) {
            sum += (3 * i + N) * (N - i + 1) / 2;
        }
        System.out.print(sum);
    }
}
