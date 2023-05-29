import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int T, N, K, last;
    static int[] time;
    static int[] preTime;
    static int[] indegree;
    static Deque<Integer> que;
    static ArrayList<Integer>[] arr;
    static StringBuilder sb = new StringBuilder();

    static void solution() {
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                que.add(i);
                preTime[i] = time[i];
            }
        }
        while (!que.isEmpty()) {
            int X = que.poll();
            for (int Y : arr[X]) {
                indegree[Y]--;
                if (indegree[Y] == 0) que.add(Y);
                preTime[Y] = Math.max(preTime[Y], preTime[X] + time[Y] );
            }
        }
        sb.append(preTime[last]).append('\n');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            time = new int[N + 1];
            preTime = new int[N + 1];
            indegree = new int[N + 1];

            arr = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                arr[i] = new ArrayList<>();
            }

            que = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                arr[X].add(Y);
                indegree[Y]++;
            }

            last = Integer.parseInt(br.readLine());
            solution();
        }
        System.out.println(sb);
    }
}
