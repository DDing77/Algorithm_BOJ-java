import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private boolean flag;

    private boolean check(String str) {
        int length = str.length();
        for (int i = 1; i <= length / 2; i++) {
            if (str.substring(length - i * 2, length - i)
                    .equals(str.substring(length - i))) {
                return false;
            }
        }
        return true;
    }

    private void backTrack(int idx, String str) {
        if (flag) {
            return;
        }

        if (idx == N) {
            flag = true;
            System.out.println(str);
        }

        for (int i = 1; i <= 3; i++) {
            String nextStr = str.concat(String.valueOf(i));
            if (check(nextStr)) {
                backTrack(idx + 1, nextStr);
            }
        }
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());

        String str = "";
        backTrack(0, str);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
