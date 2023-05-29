import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[] isVisited;
    static int[] cnt;
    static ArrayList<Integer>[] list;
    static int max = Integer.MIN_VALUE;

    static void BFS(int start) {
        isVisited = new boolean[N + 1];
        Queue<Integer> que = new LinkedList<>();
        isVisited[start] = true;
        que.add(start);

        while (!que.isEmpty()) {
            int now = que.poll();
            for (int next : list[now]) {
                if (isVisited[next]) continue;
                cnt[next]++;
                que.add(next);
                isVisited[next] = true;

                if (max < cnt[next]) {
                    max = cnt[next];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cnt = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(end);
        }


        for (int i = 1; i <= N; i++) {
            BFS(i);
        }
        for (int i = 1; i <= N; i++) {
            if (max == cnt[i]) sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
