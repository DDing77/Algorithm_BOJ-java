import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private final int MAX_LENGTH = 10_000;
    private int N;
    private int a;
    private int b;
    private int[] bridges;
    private boolean[] isVisited;
    private int res;

    private class Frog {
        int pos;
        int cnt;

        public Frog(int pos, int cnt) {
            this.pos = pos;
            this.cnt = cnt;
        }
    }

    public void execBFS() {
        isVisited = new boolean[MAX_LENGTH + 1];
        Queue<Frog> que = new LinkedList<>();
        que.add(new Frog(a, 0));
        isVisited[a] = true;

        while (!que.isEmpty()) {
            Frog cur = que.poll();

            int next = cur.pos;

            while (next <= N) {
                next += bridges[cur.pos];

                if (next > N) {
                    break;
                }

                if (isVisited[next]) {
                    continue;
                }

                if (next == b) {
                    res = cur.cnt + 1;
                    return;
                }

                isVisited[next] = true;
                que.add(new Frog(next, cur.cnt + 1));
            }

            next = cur.pos;
            while (next >= 1) {
                next -= bridges[cur.pos];

                if (next < 1) break;

                if (isVisited[next]) {
                    continue;
                }

                if (next == b) {
                    res = cur.cnt + 1;
                    return;
                }

                isVisited[next] = true;
                que.add(new Frog(next, cur.cnt + 1));
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        bridges = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            bridges[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        res = 0;
        execBFS();

        if (res == 0) {
            System.out.println("-1");
        } else {
            System.out.println(res);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
