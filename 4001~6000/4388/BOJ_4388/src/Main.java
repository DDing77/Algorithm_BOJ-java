import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int a;
    int b;
    int res;

    private void solution() throws IOException {

        while (true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0) {
                break;
            }

            res = 0;
            int carry = 0;

            while (a != 0 || b != 0) {
                int lastA = a % 10;
                int lastB = b % 10;

                a /= 10;
                b /= 10;

                if (lastA + lastB + carry > 9) {
                    res++;
                    carry = 1;
                } else {
                    carry = 0;
                }
            }
            sb.append(res).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
