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
    private int M;
    private int[] baseTime;
    private int res;

    private PriorityQueue<Subject> pq = new PriorityQueue<>((o1, o2) -> o2.plus - o1.plus);

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()) * 24;
        M = Integer.parseInt(st.nextToken());

        baseTime = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            baseTime[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int plus = Integer.parseInt(st.nextToken());
            pq.add(new Subject(i, plus));
        }

        while (!pq.isEmpty()) {
            Subject subject = pq.poll();

            int needTime = Math.min(N, (100 - baseTime[subject.idx]) / subject.plus);
            baseTime[subject.idx] += needTime * subject.plus;
            N -= needTime;

            if (baseTime[subject.idx] < 100) {
                pq.add(new Subject(subject.idx, 100 - baseTime[subject.idx]));
            }

            if (N == 0) {
                break;
            }
        }

        for (int time : baseTime) {
            res += time;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Subject {
        int idx;
        int plus;

        public Subject(int idx, int plus) {
            this.idx = idx;
            this.plus = plus;
        }
    }
}
