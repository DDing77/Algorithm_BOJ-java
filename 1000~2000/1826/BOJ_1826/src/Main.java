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
    private PriorityQueue<Station> pq;
    private int L;
    private int P;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.a));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Station(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        int curPos = P;
        int resCnt = 0;
        PriorityQueue<Integer> fuelQ = new PriorityQueue<>(Comparator.reverseOrder());

        while (curPos < L) {
            while (!pq.isEmpty() && pq.peek().a <= curPos) {
                Station curStation = pq.poll();
                fuelQ.add(curStation.b);
            }

            if (fuelQ.isEmpty()) {
                resCnt = -1;
                break;
            }

            resCnt++;
            curPos += fuelQ.poll();
        }

        System.out.println(resCnt);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Station {
        int a;
        int b;

        public Station(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
