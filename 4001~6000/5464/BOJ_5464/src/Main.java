import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int[] prices;
    private int[] weights;
    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    private int[] usingNumber;
    private int res;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        prices = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            prices[i] = Integer.parseInt(br.readLine());
        }

        weights = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            weights[i] = Integer.parseInt(br.readLine());
        }

        usingNumber = new int[M + 1];
        for (int i = 1; i <= N; i++) {
            pq.add(i);
        }

        Queue<Integer> waiting = new ArrayDeque<>();

        for (int i = 0; i < M * 2; i++) {
            int number = Integer.parseInt(br.readLine());

            if (number < 0) {
                int car = -number;
                int space = usingNumber[car];
                pq.add(space);

                if (!waiting.isEmpty()) {
                    int nextCar = waiting.poll();
                    int nextSpace = pq.poll();
                    res += prices[nextSpace] * weights[nextCar];
                    usingNumber[nextCar] = nextSpace;
                }

            } else {
                if (pq.isEmpty()) {
                    waiting.add(number);
                } else {
                    int parkNumber = pq.poll();
                    res += prices[parkNumber] * weights[number];
                    usingNumber[number] = parkNumber;
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
