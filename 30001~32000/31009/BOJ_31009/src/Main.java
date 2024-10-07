import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    PriorityQueue<Integer> pq;
    private int target;
    private int res;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cityName = st.nextToken();
            int cost = Integer.parseInt(st.nextToken());

            if (cityName.equals("jinju")) {
                target = cost;
            } else {
                pq.add(cost);
            }
        }

        while (!pq.isEmpty() && pq.peek() > target) {
            res++;
            pq.poll();
        }
        sb.append(target).append('\n').append(res);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
