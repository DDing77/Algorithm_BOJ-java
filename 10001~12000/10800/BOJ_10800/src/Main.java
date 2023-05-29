import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Ball[] balls;
    static int[] colorSum;
    static int[] resSum;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        balls = new Ball[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            balls[i] = new Ball(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(balls);

        colorSum = new int[N + 1];
        resSum = new int[N];

        int sum = 0;
        int ballIdx = 0;
        for (int i = 0; i < N; i++) {
            Ball cur = balls[i];
            while (balls[ballIdx].size < cur.size) {
                colorSum[balls[ballIdx].color] += balls[ballIdx].size;
                sum += balls[ballIdx].size;
                ballIdx++;
            }

            resSum[cur.idx] = sum - colorSum[cur.color];
        }

        for (int i = 0; i < N; i++) {
            sb.append(resSum[i]).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static class Ball implements Comparable<Ball> {
        int idx;
        int color;
        int size;

        public Ball(int idx, int color, int size) {
            this.idx = idx;
            this.color = color;
            this.size = size;
        }

        @Override
        public int compareTo(Ball o) {
            return this.size - o.size;
        }
    }
}
