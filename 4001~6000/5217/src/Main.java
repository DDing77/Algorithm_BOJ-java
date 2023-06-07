import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final String message = "Pairs for ";
    static int T;
    static int n;
    static int res;


    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());

            sb.append(message).append(n + ": ");
            res = 0;

            for (int i = 1; i <= n / 2; i++) {
                if (n - i != i) {
                    if (res != 0) {
                        sb.append(", ");
                    }
                    sb.append(i + " " + (n - i));
                    res++;
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}