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
    private PriorityQueue<Integer> pq;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int ticketNum = 1;
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            if (ticketNum < cur) {
                System.out.println(ticketNum);
                return;
            }
            ticketNum++;
        }

        System.out.println(ticketNum);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
