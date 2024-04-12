import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int T;
    int[] alpha;

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            alpha = new int[26];
            String input = br.readLine();
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (ch != ' ') {
                    alpha[ch - 'a']++;
                }
            }

            int max = 0;
            char result = 'a';
            boolean same = false;
            for (int i = 0; i < alpha.length; i++) {
                if (alpha[i] > max) {
                    max = alpha[i];
                    result = (char) (i + 'a');
                    same = false;
                } else if (alpha[i] == max) {
                    same = true;
                }
            }

            if (same) {
                sb.append("?").append("\n");
            } else {
                sb.append(result).append("\n");
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
