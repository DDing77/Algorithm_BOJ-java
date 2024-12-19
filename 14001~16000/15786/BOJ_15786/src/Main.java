import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private char[] post;
    private char[] candidate;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        post = br.readLine().toCharArray();

        for (int i = 0; i < M; i++) {
            candidate = br.readLine().toCharArray();

            boolean flag = false;
            int idx = 0;
            for (int j = 0; j < candidate.length; j++) {
                if (candidate[j] == post[idx]) {
                    idx++;
                }
                if (idx == post.length) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                sb.append("false");
            } else {
                sb.append("true");
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
