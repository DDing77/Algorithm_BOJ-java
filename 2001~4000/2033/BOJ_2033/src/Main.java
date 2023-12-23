import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int N;
    int res;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        res = N;
        int x = 1;
        while (N > 9) {
            int a = N % 10;
            if (a >= 5) {
                res += (10 - a) * x;
                N += 10;
            } else {
                res -= a * x;
            }
            N /= 10;
            x *= 10;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
