import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private class Status {
        int idx;
        char lineType;
        int cnt;

        public Status(int idx, char lineType, int cnt) {
            this.idx = idx;
            this.lineType = lineType;
            this.cnt = cnt;
        }
    }

    private int N, K;
    private boolean[] a, b;

    public boolean bfs() {
        boolean[][] isVisited = new boolean[2][N + 1];
        Queue<Status> que = new LinkedList<>();
        que.add(new Status(1, 'a', 1));
        isVisited[0][1] = true;

        while (!que.isEmpty()) {
            Status cur = que.poll();
            if (cur.idx + 1 > N || cur.idx + K > N) {
                return true;
            }

            if (cur.lineType == 'a') {
                if (a[cur.idx + 1] && !isVisited[0][cur.idx + 1]) {
                    que.add(new Status(cur.idx + 1, 'a', cur.cnt + 1));
                    isVisited[0][cur.idx + 1] = true;
                }
                if (a[cur.idx - 1] && !isVisited[0][cur.idx - 1] && cur.idx - 1 > cur.cnt) {
                    que.add(new Status(cur.idx - 1, 'a', cur.cnt + 1));
                    isVisited[0][cur.idx - 1] = true;
                }
                if (b[cur.idx + K] && !isVisited[1][cur.idx + K]) {
                    que.add(new Status(cur.idx + K, 'b', cur.cnt + 1));
                    isVisited[1][cur.idx + K] = true;
                }
            } else {
                if (b[cur.idx + 1] && !isVisited[1][cur.idx + 1]) {
                    que.add(new Status(cur.idx + 1, 'b', cur.cnt + 1));
                    isVisited[1][cur.idx + 1] = true;
                }
                if (b[cur.idx - 1] && !isVisited[1][cur.idx - 1] && cur.idx - 1 > cur.cnt) {
                    que.add(new Status(cur.idx - 1, 'b', cur.cnt + 1));
                }
                if (a[cur.idx + K] && !isVisited[0][cur.idx + K]) {
                    que.add(new Status(cur.idx + K, 'a', cur.cnt + 1));
                    isVisited[0][cur.idx + K] = true;
                }
            }
        }
        return false;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        a = new boolean[N + 1];
        String input = br.readLine();
        for (int i = 1; i <= N; i++) {
            if (input.charAt(i - 1) == '1') {
                a[i] = true;
            }
        }

        b = new boolean[N + 1];
        input = br.readLine();
        for (int i = 1; i <= N; i++) {
            if (input.charAt(i - 1) == '1') {
                b[i] = true;
            }
        }

        if (!bfs()) {
            System.out.println("0");
        } else {
            System.out.println("1");
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
