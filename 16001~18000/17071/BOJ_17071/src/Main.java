import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final int SIZE = 500_000;
    final int[] dir = {-1, 1, 2};
    int N;
    int K;
    boolean[][] isVisited;
    int res;

    public void execBFS() {
        isVisited = new boolean[SIZE + 1][2];
        Queue<Integer> que = new ArrayDeque<>();
        que.add(N);
        int time = 0;
        isVisited[N][time] = true;

        while (!que.isEmpty()) {
            if (K > SIZE) {
                break;
            }

            if (isVisited[K][time % 2]) {
                res = time;
                break;
            }

            int queSize = que.size();
            for (int i = 0; i < queSize; i++) {
                int cur = que.poll();
                int nextTime = time + 1;

                for (int j = 0; j < dir.length; j++) {
                    int next = cur + dir[j];

                    if (j == dir.length - 1) {
                        next = cur * 2;
                    }

                    if (0 <= next && next <= SIZE && !isVisited[next][nextTime % 2]) {
                        isVisited[next][nextTime % 2] = true;
                        que.add(next);
                    }
                }
            }
            K += ++time;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        res = -1;
        execBFS();

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
