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

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        PriorityQueue<Problem> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Problem(st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        Problem easy = pq.poll();
        System.out.println(easy.title);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Problem implements Comparable<Problem> {

        String title;
        int difficult;

        public Problem(String title, int difficult) {
            this.title = title;
            this.difficult = difficult;
        }

        @Override
        public int compareTo(Problem o) {

            return this.difficult - o.difficult;
        }
    }
}
