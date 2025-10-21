import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int K;
    private HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    private int res;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 11; i++) {
            map.put(i, new PriorityQueue<>(Comparator.reverseOrder()));
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            map.get(number).add(value);
        }

        for (int i = 0; i < K; i++) {
            for (int j = 1; j <= 11; j++) {
                PriorityQueue<Integer> pq = map.get(j);
                if (!pq.isEmpty()) {
                    int nextValue = pq.poll() - 1;
                    pq.add(nextValue);
                }
            }
        }

        for (int i = 1; i <= 11; i++) {
            PriorityQueue<Integer> pq = map.get(i);
            if (!pq.isEmpty()) {
                res += pq.peek();
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
