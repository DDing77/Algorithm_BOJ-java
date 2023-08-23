import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    long N;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());

        long q = (long) Math.sqrt(N);
        if (q * q < N) q++;

        System.out.println(q);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
