import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int C;
    private int M;

    private Box[] boxes;
    private int[] load;
    private int res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        boxes = new Box[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            boxes[i] = new Box(from, to, cnt);
        }

        Arrays.sort(boxes, (o1, o2) -> {
            if (o1.to == o2.to) {
                return o1.from - o2.from;
            }
            return o1.to - o2.to;
        });

        load = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int from = boxes[i].from;
            int to = boxes[i].to;
            int cnt = boxes[i].cnt;

            int maxLoad = 0;
            for (int pos = from; pos < to; pos++) {
                maxLoad = Math.max(maxLoad, load[pos]);
            }

            int canLoad = Math.min(cnt, C - maxLoad);
            if (canLoad <= 0) {
                continue;
            }

            for (int pos = from; pos < to; pos++) {
                load[pos] += canLoad;
            }

            res += canLoad;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Box {
        int from;
        int to;
        int cnt;

        public Box(int from, int to, int cnt) {
            this.from = from;
            this.to = to;
            this.cnt = cnt;
        }
    }
}
