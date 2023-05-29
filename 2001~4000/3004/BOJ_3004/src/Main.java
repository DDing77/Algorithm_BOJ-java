import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        if (N % 2 == 1) {
            System.out.println((((N - 1) / 2) + 1) * (((N + 1) / 2) + 1));
        } else {
            N /= 2;
            N += 1;
            System.out.println(N * N);
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
