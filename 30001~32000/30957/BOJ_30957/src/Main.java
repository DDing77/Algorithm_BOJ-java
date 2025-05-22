import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int BCnt;
    private int SCnt;
    private int ACnt;
    private int maxCount;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());

        String input = br.readLine();
        for (char c : input.toCharArray()) {
            if (c == 'B') {
                BCnt++;
                if (BCnt > maxCount) {
                    maxCount = BCnt;
                }
            } else if (c == 'S') {
                SCnt++;
                if (SCnt > maxCount) {
                    maxCount = SCnt;
                }
            } else if (c == 'A') {
                ACnt++;
                if (ACnt > maxCount) {
                    maxCount = ACnt;
                }
            }
        }

        if (BCnt == ACnt && ACnt == SCnt) {
            System.out.println("SCU");
        } else {
            if (BCnt == maxCount) {
                sb.append("B");
            }
            if (SCnt == maxCount) {
                sb.append("S");
            }
            if (ACnt == maxCount) {
                sb.append("A");
            }
            System.out.println(sb);
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
