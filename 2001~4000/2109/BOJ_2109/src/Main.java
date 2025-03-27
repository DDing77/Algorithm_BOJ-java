import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private boolean[] isVisited;
    private int res;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Request> pq = new PriorityQueue<>();

        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            max = Math.max(max, d);
            pq.add(new Request(p, d));
        }

        isVisited = new boolean[max + 1];
        while (!pq.isEmpty()) {
            Request request = pq.poll();
            for (int i = request.d; i >= 1; i--) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    res += request.p;
                    break;
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Request implements Comparable<Request> {

        int p;
        int d;

        public Request(int p, int d) {
            this.p = p;
            this.d = d;
        }

        @Override
        public int compareTo(Request o) {
            if (this.p == o.p) {
                return o.d - this.d;
            }
            return o.p - this.p;
        }
    }
}
