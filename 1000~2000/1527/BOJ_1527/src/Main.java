import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int A;
    private int B;
    private int res;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        Queue<Long> que = new ArrayDeque<>();
        que.add(4L);
        que.add(7L);

        while (!que.isEmpty()) {
            long cur = que.poll();

            if (A <= cur && cur <= B) {
                res++;
            }

            long next = cur * 10 + 4;
            if (next <= B && next <= 1_000_000_000) {
                que.add(next);
            }
            next = cur * 10 + 7;
            if (next <= B && next <= 1_000_000_000) {
                que.add(next);
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
