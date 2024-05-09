import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int n;

    private void solution() throws IOException {

        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String input = br.readLine();
            String lower = input.toLowerCase();
            int gCnt = 0;
            int bCnt = 0;

            for (int i = 0; i < lower.length(); i++) {
                char cur = lower.charAt(i);
                if (cur == 'g') {
                    gCnt++;
                } else if (cur == 'b') {
                    bCnt++;
                }
            }

            if (gCnt > bCnt) {
                sb.append(input).append(" is GOOD");
            } else if (gCnt < bCnt) {
                sb.append(input).append(" is A BADDY");
            } else {
                sb.append(input).append(" is NEUTRAL");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
