import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private int A;
    private int K;
    private boolean[] isVisited;
    private int res;

    private class Point {
        int value;
        int cnt;

        public Point(int value, int cnt) {
            this.value = value;
            this.cnt = cnt;
        }
    }

    public void execBFS() {
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(A, 0));
        isVisited[A] = true;

        while (!que.isEmpty()) {
            Point cur = que.poll();
            if (cur.value == K) {
                res = cur.cnt;
                return;
            }

            int next;

            for (int k = 0; k < 2; k++) {
                if (k == 0) {
                    next = cur.value + 1;
                } else {
                    next = cur.value * 2;
                }
                if (next > K) {
                    continue;
                }

                if (isVisited[next]) {
                    continue;
                }

                que.add(new Point(next, cur.cnt + 1));
                isVisited[next] = true;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        isVisited = new boolean[K + 1];

        execBFS();

        System.out.println(res);

    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
