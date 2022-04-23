import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static final int M = 1234567891;
    static String input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = br.readLine();

        long res = 0;
        long pow = 1;
        for (int i = 0; i < N; i++) {
            res += ((input.charAt(i) - 'a' +1) * pow) % M;
            pow = (pow * 31 )% M;
        }
        System.out.println(res % M);
    }
}