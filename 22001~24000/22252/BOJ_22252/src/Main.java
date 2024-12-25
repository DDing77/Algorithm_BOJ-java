import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private Map<String, PriorityQueue<Integer>> items;
    private long res;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        // 10 8
        // 4 4 2 3
        items = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int count = Integer.parseInt(st.nextToken());
            if (op == 2) {
                if (!items.containsKey(name)) {
                    continue;
                }
                PriorityQueue<Integer> pq = items.get(name);
                while (!items.get(name).isEmpty() && count > 0) {
                    res += pq.poll();
                    count--;
                }
            } else if (op == 1) {
                PriorityQueue<Integer> pq = items.computeIfAbsent(name, k -> new PriorityQueue<>(Comparator.reverseOrder()));
                for (int j = 0; j < count; j++) {
                    pq.add(Integer.parseInt(st.nextToken()));
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
