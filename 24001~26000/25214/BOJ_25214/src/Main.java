import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int min = Integer.parseInt(st.nextToken());
        int max = min;
        int diffMax = max - min;

        sb.append(diffMax).append(" ");

        for (int i = 1; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());

            diffMax = Math.max(diffMax, cur - min);
            min = Math.min(min, cur);
            max = Math.max(max, cur);

            sb.append(diffMax).append(" ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
