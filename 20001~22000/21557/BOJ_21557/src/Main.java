import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] heights = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int height : heights) {
            deque.offerLast(height);
        }

        while (deque.size() > 2) {
            int left = deque.peekFirst();
            int right = deque.peekLast();

            if (left < right) {
                int last = deque.pollLast();
                deque.pollLast();
                int prev = deque.pollLast();

                prev--;
                last--;

                if (prev > 0) {
                    deque.offerLast(prev);
                }
                if (last > 0) {
                    deque.offerLast(last);
                }
            } else {
                int first = deque.pollFirst();
                deque.pollFirst();
                int next = deque.pollFirst();

                first--;
                next--;

                if (next > 0) {
                    deque.offerFirst(next);
                }
                if (first > 0) {
                    deque.offerFirst(first);
                }
            }
        }

        int a = deque.pollFirst();
        int b = deque.pollFirst();

        sb.append(Math.max(a, b)).append('\n');
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}