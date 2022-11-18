import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;
    static int[] answer;
    static int[] in;
    static ArrayList<Integer>[] adj;

    static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (in[i] == 0) que.add(i);
        }

        int semester = 1;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int cur = que.poll();
                answer[cur] = semester;
                for (int next : adj[cur]) {
                    in[next]--;
                    if (in[next] == 0) que.add(next);
                }
            }
            semester++;
        }
    }

    // 4 6 2 3
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        answer = new int[N + 1];
        in = new int[N + 1];

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adj[from].add(to);
            in[to]++;
        }

        bfs();
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i] + " ");
        }

        System.out.println(sb);
    }
}
