import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int res;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        res = 0;

        for (int i = 1; i <= N; i++) {
            int sum = 0;
            int temp = i;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if (i % sum == 0) {
                res++;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
