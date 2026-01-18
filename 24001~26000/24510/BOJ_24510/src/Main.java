import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int C;
    private Pattern pattern;

    private void solution() throws IOException {
        C = Integer.parseInt(br.readLine());
        pattern = Pattern.compile("for|while");

        int answer = 0;

        for (int i = 0; i < C; i++) {
            String line = br.readLine();

            Matcher matcher = pattern.matcher(line);
            int cnt = 0;
            while (matcher.find()) {
                cnt++;
            }

            if (cnt > answer) {
                answer = cnt;
            }
        }

        sb.append(answer);
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
