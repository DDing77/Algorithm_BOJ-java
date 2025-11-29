import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private PriorityQueue<Integer> a = new PriorityQueue<>();
    private PriorityQueue<Integer> b = new PriorityQueue<>();
    private int res;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int length = Integer.parseInt(st.nextToken());

            if (length < 10) {
                continue;
            }

            if (length % 10 == 0) {
                a.add(length);
            } else {
                b.add(length);
            }
        }

        while (!a.isEmpty() && M > 0) {
            int cur = a.poll();
            res++;
            if (cur == 10) {
                continue;
            }

            int next = cur - 10;
            M--;
            if (next >= 10) {
                a.add(next);
            }
        }

        while (!b.isEmpty() && M > 0) {
            int cur = b.poll();
            res++;
            if (cur == 10) {
                res++;
            }

            int next = cur - 10;
            M--;
            if (next >= 10) {
                b.add(next);
            }
        }

        if (!a.isEmpty()) {
            int cur = a.poll();
            if (cur == 10) {
                res++;
            }
        }

        if (!b.isEmpty()) {
            int cur = b.poll();
            if (cur == 10) {
                res++;
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
