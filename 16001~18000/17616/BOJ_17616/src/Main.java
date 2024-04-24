import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int M;
    int X;
    ArrayList<Integer>[] upRank;
    ArrayList<Integer>[] downRank;

    private int execBFS(ArrayList<Integer>[] edges) {
        Queue<Integer> que = new ArrayDeque<>();
        boolean[] isVisited = new boolean[N + 1];
        que.add(X);
        isVisited[X] = true;

        int count = 0;
        while (!que.isEmpty()) {
            int cur = que.poll();
            count++;

            for (int next : edges[cur]) {
                if (isVisited[next]) {
                    continue;
                }

                que.add(next);
                isVisited[next] = true;
            }
        }

        return count;
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        upRank = IntStream.rangeClosed(0, N)
                .mapToObj(i -> new ArrayList<Integer>())
                .toArray(ArrayList[]::new);

        downRank = IntStream.rangeClosed(0, N)
                .mapToObj(i -> new ArrayList<Integer>())
                .toArray(ArrayList[]::new);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            upRank[b].add(a);
            downRank[a].add(b);
        }

        sb.append(execBFS(upRank)).append(" ").append(N + 1 - execBFS(downRank));
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
