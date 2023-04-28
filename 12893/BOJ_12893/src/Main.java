import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private int N;
    private int M;
    private int[] set;
    private ArrayList<Integer>[] adj;

    public void execBFS() {
        set = new int[N + 1];
        Queue<Integer> que = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (set[i] == 0) {
                que.add(i);
                set[i] = 1;
            }

            while (!que.isEmpty()) {
                int cur = que.poll();

                for (int next : adj[cur]) {
                    if (set[next] == 0) {
                        if (set[cur] == 1) {
                            set[next] = 2;
                        } else {
                            set[next] = 1;
                        }
                        que.add(next);
                    } else {
                        if (set[cur] == set[next]) {
                            System.out.println("0");
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("1");
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adj[from].add(to);
            adj[to].add(from);
        }

        execBFS();

    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
