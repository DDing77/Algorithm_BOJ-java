import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 1; i < Math.sqrt(N); i++) {
            if (1 + i + i * i == N) {
                System.out.println(i);
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
