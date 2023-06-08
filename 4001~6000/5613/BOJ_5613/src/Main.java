import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int res;
    static boolean first;
    static String op;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        res = 0;
        String cur;
        while (true) {
            cur = br.readLine();

            if (!first) {
                first = true;
                res = Integer.parseInt(cur);
                continue;
            }

            if (cur.equals("=")) {
                break;
            }

            if (cur.equals("+") || cur.equals("-") || cur.equals("*") || cur.equals("/")) {
                op = cur;
                continue;
            }

            if (op.equals("+")) {
                res += Integer.parseInt(cur);
            }

            if (op.equals("-")) {
                res -= Integer.parseInt(cur);
            }

            if (op.equals("*")) {
                res *= Integer.parseInt(cur);
            }

            if (op.equals("/")) {
                res /= Integer.parseInt(cur);
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
