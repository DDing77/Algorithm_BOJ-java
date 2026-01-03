import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int n;
    private String words;

    private void solution() throws IOException {
        n = Integer.parseInt(br.readLine());
        words = br.readLine();

        for (int i = 0; i < n; i++) {
            char cur = words.charAt(i);
            if (cur == 'I') {
                sb.append('i');
            } else if (cur == 'l') {
                sb.append('L');
            } else {
                sb.append(cur);
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
