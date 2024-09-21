import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private int res;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            res = 0;
            for (int j = 0; j < input.length(); j++) {
                char ch = input.charAt(j);
                if ('A' <= ch && ch <= 'Z') {
                    res += ch - 'A' + 1;
                }
            }

            if (res == 100) {
                sb.append("PERFECT LIFE");
            } else {
                sb.append(res);
            }

            if (i != N - 1) {
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
