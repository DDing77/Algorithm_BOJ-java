import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static int idx = 0;

    private int n;
    private int T;
    private boolean[] isVisited;
    private HashMap<Integer, List<int[]>> map = new HashMap<>();
    private int res = -1;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map.computeIfAbsent(y, k -> new ArrayList<>()).add(new int[]{x, idx++});
        }

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{0, 0, 0});
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[1] == T) {
                res = cur[2];
                break;
            }

            for (int i = cur[1] - 2; i <= cur[1] + 2; i++) {
                if (i < 0 || i > T) {
                    continue;
                }

                if (map.get(i) == null) {
                    continue;
                }

                for (int[] node : map.get(i)) {
                    if (isVisited[node[1]]) {
                        continue;
                    }
                    if (Math.abs(node[0] - cur[0]) > 2) {
                        continue;
                    }

                    isVisited[node[1]] = true;
                    que.add(new int[]{node[0], i, cur[2] + 1});
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
