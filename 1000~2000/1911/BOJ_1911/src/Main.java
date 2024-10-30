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
    private int L;
    private PriorityQueue<Pot> pq;
    private int res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Pot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int last = 0;
        for (int i = 0; i < N; i++) {
            Pot cur = pq.poll();
            if (cur.right <= last) {
                continue;
            }

            last = Math.max(last, cur.left);
            int diff = cur.right - last;

            int q = diff / L;
            if (diff % L != 0) {
                q++;
            }

            res += q;
            last += L * q;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Pot implements Comparable<Pot> {

        int left;
        int right;

        public Pot(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Pot o) {
            return this.left - o.left;
        }
    }

}
