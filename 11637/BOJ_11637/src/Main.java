import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final String[] message = {
            "majority winner",
            "minority winner",
            "no winner"
    };
    static int T, N, res;
    static int sum;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            sum = 0;
            int max = -1;
            int maxId = 0;
            int cur;
            boolean isSame = false;

            for (int i = 0; i < N; i++) {
                cur = Integer.parseInt(br.readLine());
                if (cur > max) {
                    max = cur;
                    maxId = i + 1;
                    isSame = false;
                } else if (cur == max) {
                    isSame = true;
                }
                sum += cur;
            }

            if (isSame) {
                sb.append(message[2]);
            } else if (max >= sum / 2 + 1) {
                sb.append(message[0] + " " + maxId);
            } else {
                sb.append(message[1] + " " + maxId);
            }

            sb.append('\n');
        }
        System.out.print(sb);
    }
}
