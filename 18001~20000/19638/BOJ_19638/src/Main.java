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
    private int H;
    private int T;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());


        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int count = 0;
        while (T > 0 && !pq.isEmpty()) {
            int height = pq.peek();
            if (H > height) {
                break;
            }
            if (height == 1) {
                break;
            }
            pq.add(pq.poll() / 2);
            T--;
            count++;
        }

        if (H > pq.peek()) {
            sb.append("YES").append('\n').append(count);
        } else {
            sb.append("NO").append('\n').append(pq.peek());
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
