import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private class Info {
        int nodeNum;
        int passCnt;

        public Info(int nodeNum, int passCnt) {
            this.nodeNum = nodeNum;
            this.passCnt = passCnt;
        }
    }

    private int N, M, K, X;
    private ArrayList<Integer>[] edges;
    private int cnt;
    private int[] distance;

    public void getResult() {
        distance[X] = 0;

        Queue<Info> que = new LinkedList<>();
        que.add(new Info(X, 0));

        while (!que.isEmpty()) {
            Info cur = que.poll();

            for (int next : edges[cur.nodeNum]) {
                if (distance[next] == -1) {
                    if (cur.passCnt + 1 == K) {
                        distance[next] = cur.passCnt + 1;
                        cnt++;
                        continue;
                    }

                    que.add(new Info(next, cur.passCnt + 1));
                    distance[next] = cur.passCnt + 1;
                }
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            edges[start].add(end);
        }

        distance = new int[N + 1];
        Arrays.fill(distance, -1);
        cnt = 0;
        getResult();

        if (cnt == 0) {
            System.out.println("-1");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                sb.append(i).append('\n');
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
