import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long N;
    static long sum;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine());
        sum = (N - 1) * (N + 1 + (N + 1) * (N - 1)) / 2;
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
