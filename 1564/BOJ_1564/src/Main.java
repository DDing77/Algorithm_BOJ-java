import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static long temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        temp = 1L;
        for (int i = 1; i <= N; i++) {
            temp *= i;
            while (temp % 10 == 0) temp /= 10;
            temp %= 1e12;
        }
        temp %= 100000;
        System.out.println(String.format("%05d", temp));
    }
}
