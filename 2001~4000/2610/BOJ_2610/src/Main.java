import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final int INF = 101;
    int N;
    int M;
    int[][] dp;
    boolean[] isVisited;
    ArrayList<Integer> groupLeader;
    ArrayList<Integer> groupMember;

    public void execBFS(int start) {
        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);
        isVisited[start] = true;

        groupMember = new ArrayList<>();
        groupMember.add(start);

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int next = 1; next <= N; next++) {
                if (!isVisited[next] && dp[cur][next] != INF) {
                    que.add(next);
                    isVisited[next] = true;
                    groupMember.add(next);
                }
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dp[i][j] > dp[i][k] + dp[k][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                    }
                }
            }
        }

        int readerIdx = start;
        int res = Integer.MAX_VALUE;
        for (int cur : groupMember) {
            int max = 0;
            for (int next : groupMember) {
                if (cur == next) {
                    continue;
                }

                max = Math.max(max, dp[cur][next]);
            }

            if (res > max) {
                res = max;
                readerIdx = cur;
            }
        }

        groupLeader.add(readerIdx);
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        isVisited = new boolean[N + 1];
        dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    dp[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            dp[from][to] = 1;
            dp[to][from] = 1;
        }

        groupLeader = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (!isVisited[i]) {
                execBFS(i);
            }
        }

        Collections.sort(groupLeader);
        sb.append(groupLeader.size()).append('\n');
        for (int number : groupLeader) {
            sb.append(number).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
