import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[][] courses;
    private PriorityQueue<Integer> pq;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        courses = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                courses[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(courses, Comparator.comparingInt(o -> o[1]));

        pq = new PriorityQueue<>();
        for (int[] course : courses) {
            if (pq.isEmpty()) {
                pq.add(course[2]);
                continue;
            }

            if (pq.peek() <= course[1]) {
                pq.poll();
            }
            pq.add(course[2]);
        }

        System.out.println(pq.size());
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
