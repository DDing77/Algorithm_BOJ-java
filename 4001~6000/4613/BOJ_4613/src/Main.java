import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private void solution() throws IOException {
        while (true) {
            char[] words = br.readLine().toCharArray();
            if (words.length == 1 && words[0] == '#') {
                break;
            }

            int res = 0;
            for (int i = 0; i < words.length; i++) {
                char c = words[i];
                if (c == ' ') {
                    continue;
                }
                res += ((c - 'A') + 1) * (i + 1);
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
