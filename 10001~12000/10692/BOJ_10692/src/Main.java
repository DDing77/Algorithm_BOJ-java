import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int T;
    private String S;

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            S = br.readLine();
            int n = S.length();

            sb.append("Case ").append(tc).append(": ");

            String res = findLongestString(n);

            if (res == null) {
                sb.append("-1");
            } else {
                sb.append(res);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private String findLongestString(int n) {
        for (int len = n / 3; len >= 1; len--) {
            if (!isSame(0, n - len, len)) {
                continue;
            }

            if (existsMiddle(len, n)) {
                return S.substring(0, len);
            }
        }

        return null;
    }

    private boolean existsMiddle(int len, int n) {
        for (int start = len; start <= n - 2 * len; start++) {
            if (isSame(0, start, len)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSame(int a, int b, int len) {
        for (int i = 0; i < len; i++) {
            if (S.charAt(a + i) != S.charAt(b + i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}