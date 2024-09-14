import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private int a;
    private int b;
    private char[] words;

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            words = br.readLine().toCharArray();
            for (int i = 0; i < words.length; i++) {
                sb.append((char)((((words[i] - 'A') * a + b) % 26) + 'A'));
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
