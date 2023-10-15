import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * BOJ_5107
 * author_devteo77
 */

public class Main {

    int T;
    int N;
    int res;
    HashMap<String, Integer> map;
    ArrayList<Integer>[] edges;
    boolean[] isVisited;

    public void execDFS(int cur) {
        for (int next : edges[cur]) {
            if (isVisited[next]) {
                res++;
                return;
            }

            isVisited[next] = true;
            execDFS(next);
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            int number = 1;
            map = new HashMap<>();
            edges = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                edges[i] = new ArrayList<>();
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String from = st.nextToken();
                String to = st.nextToken();

                if (!map.containsKey(from)) {
                    map.put(from, number++);
                }

                if (!map.containsKey(to)) {
                    map.put(to, number++);
                }

                edges[map.get(to)].add(map.get(from));
            }

            res = 0;
            isVisited = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    execDFS(i);
                }
            }

            sb.append(T++).append(" ").append(res).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
