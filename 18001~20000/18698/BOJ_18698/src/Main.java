import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int T;

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            char[] input = br.readLine().toCharArray();

            int step = 0;
            for (int i = 0; i < input.length; i++) {
                char c = input[i];
                if (c == 'U') {
                    step++;
                } else if (c == 'D') {
                    break;
                }
            }
            sb.append(step).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
