import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private int N;
    private Map<Integer, ArrayDeque<Integer>> map;
    private int[] numbers;
    private int[] nodes;
    private boolean res;

    private int init(int start, int end, int nodeNum) {
        if (start == end) {
            return nodes[nodeNum] = numbers[start];
        }

        int mid = (start + end) >> 1;
        return nodes[nodeNum] = Math.max(init(start, mid, nodeNum * 2), init(mid + 1, end, nodeNum * 2 + 1));
    }

    private int query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryLeft > end || queryRight < start) {
            return 0;
        }

        if (queryLeft <= start && queryRight >= end) {
            return nodes[nodeNum];
        }

        int mid = (start + end) >> 1;
        return Math.max(query(start, mid, queryLeft, queryRight, nodeNum * 2), query(mid + 1, end, queryLeft, queryRight, nodeNum * 2 + 1));
    }

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            nodes = new int[N * 4];
            numbers = new int[N + 1];
            res = true;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int value = Integer.parseInt(st.nextToken());
                numbers[i] = value;
                map.computeIfAbsent(value, k -> new ArrayDeque<>()).add(i);
            }

            init(1, N, 1);

            for (Integer value : map.keySet()) {
                if (map.get(value).size() < 2) {
                    continue;
                }
                int left = map.get(value).getFirst();
                int right = map.get(value).getLast();
                int max = query(1, N, left + 1, right - 1, 1);
                if (max > value) {
                    res = false;
                }
            }

            if (res) {
                sb.append("Yes");
            } else {
                sb.append("No");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
