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
    private PriorityQueue<Long> pq = new PriorityQueue<>();

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        long ap = Long.parseLong(st.nextToken());

        while (st.hasMoreTokens()) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        while (!pq.isEmpty()) {
            long next = pq.poll();
            if (next >= ap) {
                System.out.println("No");
                return;
            }

            ap += next;
        }
        System.out.println("Yes");
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
