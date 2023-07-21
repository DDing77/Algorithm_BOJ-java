import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long N;
    static long res;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine());

        res = N * (N - 1) * (N - 2) / 6;
        System.out.println(res + "\n" + 3);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
