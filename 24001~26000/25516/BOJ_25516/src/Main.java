import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    int N;
    int K;
    ArrayList<Integer>[] edges;
    int[] values;
    int res;

    public void execBFS() {
        boolean[] isVisited = new boolean[N];
        isVisited[0] = true;
        Queue<Integer> que = new ArrayDeque<>();
        que.add(0);
        res = values[0];

        while (!que.isEmpty() && K > 0) {
            int size = que.size();
            K--;

            for (int i = 0; i < size; i++) {
                int cur = que.poll();

                for (int next : edges[cur]) {
                    if (!isVisited[next]) {
                        isVisited[next] = true;
                        que.add(next);
                        res += values[next];
                    }
                }
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            edges[from].add(to);
        }

        values = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        res = 0;

        execBFS();

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
