import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private String input;

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            input = br.readLine();
            sb.append(input.charAt(0));
            for (int i = 1; i < input.length(); i++) {
                if (input.charAt(i) != input.charAt(i - 1)) {
                    sb.append(input.charAt(i));
                }
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
