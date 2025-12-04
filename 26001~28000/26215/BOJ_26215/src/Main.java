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
    private PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    private int res;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        while(pq.size() >= 2) {
            int a = pq.poll();
            int b = pq.poll();

            res += b;
            pq.add(a - b);
        }

        res += pq.poll();

        if (res > 1440) {
            res = -1;
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
