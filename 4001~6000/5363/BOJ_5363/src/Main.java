import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            List<String> words = new ArrayList<>();
            while (st.hasMoreTokens()) {
                words.add(st.nextToken());
            }

            for (int j = 2; j < words.size(); j++) {
                sb.append(words.get(j)).append(" ");
            }
            for (int j = 0; j < 2; j++) {
                sb.append(words.get(j)).append(" ");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
