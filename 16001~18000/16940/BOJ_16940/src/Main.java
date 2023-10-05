import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    int N;
    int[] order;
    ArrayList<Integer>[] edges;

    public boolean execBFS() {
        Queue<Integer> que = new ArrayDeque<>();
        que.add(1);
        boolean[] isVisited = new boolean[N + 1];
        isVisited[1] = true;

        int idx = 2;
        int cnt;

        while (!que.isEmpty()) {
            int cur = que.poll();
            cnt = 0;
            for (int next : edges[cur]) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    cnt++;
                }
            }

            for (int i = idx; i < idx + cnt; i++) {
                if (!isVisited[order[i]]) {
                    return false;
                } else {
                    que.add(order[i]);
                }
            }

            idx += cnt;
        }
        return true;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            edges[from].add(to);
            edges[to].add(from);
        }

        order = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        if (order[1] != 1) {
            System.out.println(0);
            return;
        }

        if (execBFS()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
