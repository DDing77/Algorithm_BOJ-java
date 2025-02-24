import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private String[] names;
    private int[] next;
    private int[] tail;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        names = new String[N + 1];

        next = new int[N + 1];
        tail = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            tail[i] = i;
            names[i] = br.readLine();
        }

        int from = 0;
        int to = 0;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());

            next[tail[from]] = to;
            tail[from] = tail[to];
        }

        while (from != 0) {
            sb.append(names[from]);
            from = next[from];
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
