import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, F;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        F = Integer.parseInt(br.readLine());

        for (int i = N - (N % 100); i <= (N / 100) * 100 + 100; i++) {
            if (i % F == 0) {
                if (i % 100 < 10) {
                    System.out.printf(String.format("%02d", i % 100));
                } else {
                    System.out.println(i % 100);
                }
                return;
            }
        }
    }
}
