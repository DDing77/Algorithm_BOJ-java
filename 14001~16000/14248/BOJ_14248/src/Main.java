import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    int N;
    int[] nodes;
    int start;

    public int execBFS() {
        int cnt = 1;
        boolean[] isVisited = new boolean[N + 1];
        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);
        isVisited[start] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();

            if (cur + nodes[cur] <= N && !isVisited[cur + nodes[cur]]) {
                que.add(cur + nodes[cur]);
                isVisited[cur + nodes[cur]] = true;
                cnt++;
            }

            if (cur - nodes[cur] > 0 && !isVisited[cur - nodes[cur]]) {
                que.add(cur - nodes[cur]);
                isVisited[cur - nodes[cur]] = true;
                cnt++;
            }
        }

        return cnt;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nodes = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nodes[i] = Integer.parseInt(st.nextToken());
        }

        start = Integer.parseInt(br.readLine());
        System.out.println(execBFS());
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
