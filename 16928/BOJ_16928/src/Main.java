import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static boolean[] isVisited;
    static int[] ladderAndSnake;
    static int[] node;

    static void bfs() {
        isVisited = new boolean[101];
        node = new int[101];

        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        node[1] = 0;
        isVisited[1] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();
            if (cur == 100) {
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int next = cur + i;
                if (next > 100) continue;
                if (isVisited[next]) continue;
                isVisited[next] = true;

                if (ladderAndSnake[next] != 0) {
                    if (!isVisited[ladderAndSnake[next]]) {
                        que.add(ladderAndSnake[next]);
                        isVisited[ladderAndSnake[next]] = true;
                        node[next] = node[cur] + 1;
                        node[ladderAndSnake[next]] = node[next];
                    }
                } else {
                    que.add(next);
                    node[next] = node[cur] + 1;
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ladderAndSnake = new int[101];

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            ladderAndSnake[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        bfs();

        System.out.println(node[100]);
    }
}
