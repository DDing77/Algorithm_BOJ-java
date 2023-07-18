import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int res;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        res = 0;
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= 500; i++) {
            int A = i * i + N;
            int sqrt = (int) Math.sqrt(A);

            if (sqrt > 500) {
                break;
            }

            if (sqrt * sqrt == A) {
                res++;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
