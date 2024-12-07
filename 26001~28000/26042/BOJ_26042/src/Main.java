import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int resMaxLength;
    private int resMaxNumber;
    private Deque<Integer> que;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        que = new ArrayDeque<>();

        resMaxLength = 0;
        resMaxNumber = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 1) {
                int b = Integer.parseInt(st.nextToken());
                que.add(b);
                if (resMaxLength < que.size()) {
                    resMaxLength = que.size();
                    resMaxNumber = que.peekLast();
                } else if (resMaxLength == que.size()) {
                    resMaxNumber = Math.min(resMaxNumber, que.peekLast());
                }
            } else {
                que.pollFirst();
            }
        }

        sb.append(resMaxLength).append(" ").append(resMaxNumber);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
