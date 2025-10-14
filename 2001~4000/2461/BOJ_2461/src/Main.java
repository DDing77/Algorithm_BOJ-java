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
    private int M;
    private int[][] students;
    private PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
    private int resMin = Integer.MAX_VALUE;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        students = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                students[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(students[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, students[i][0]);
            pq.add(new int[]{students[i][0], i, 0});
        }

        while (true) {
            int[] cur = pq.poll();
            resMin = Math.min(max - cur[0], resMin);
            if (cur[2] + 1 >= M) {
                break;
            }

            int next = students[cur[1]][cur[2] + 1];
            max = Math.max(max, next);
            pq.add(new int[]{next, cur[1], cur[2] + 1});
        }

        System.out.println(resMin);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
