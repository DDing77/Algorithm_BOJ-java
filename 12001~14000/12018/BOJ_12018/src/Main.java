import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private PriorityQueue<Integer> pq;
    private int res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            if (P < L) {
                pq.add(1);
            } else {
                int[] temp = new int[P];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = Integer.parseInt(st.nextToken());
                }

                Arrays.sort(temp);

                pq.add(temp[P - L]);
            }
        }

        while (!pq.isEmpty() && pq.peek() <= M) {
            res++;
            M -= pq.poll();
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
