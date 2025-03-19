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
    private List<Position> positions;
    private int[] nodes;
    private long res;

    private int query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryLeft > end || queryRight < start) {
            return 0;
        }

        if (queryLeft <= start && end <= queryRight) {
            return nodes[nodeNum];
        }

        int mid = (start + end) >> 1;
        return query(start, mid, queryLeft, queryRight, nodeNum * 2) +
                query(mid + 1, end, queryLeft, queryRight, nodeNum * 2 + 1);
    }

    private void update(int start, int end, int idx, int nodeNum) {
        if (idx < start || idx > end) {
            return;
        }

        nodes[nodeNum]++;

        if (start == end) {
            return;
        }

        int mid = (start + end) >> 1;
        update(start, mid, idx, nodeNum * 2);
        update(mid + 1, end, idx, nodeNum * 2 + 1);
    }

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            positions = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                positions.add(new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            Collections.sort(positions, (o1, o2) -> Integer.compare(o2.y, o1.y));

            int sparseCnt = 1;
            for (int i = 1; i < N; i++) {
                if (positions.get(i - 1).y != positions.get(i).y) {
                    sparseCnt++;
                }
                positions.get(i).sparseIdx = sparseCnt;
            }

            Collections.sort(positions, (o1, o2) -> {
                if (o1.x == o2.x) {
                    return Integer.compare(o1.sparseIdx, o2.sparseIdx);
                }
                return Integer.compare(o1.x, o2.x);
            });

            res = 0L;
            nodes = new int[N * 4];
            for (Position position : positions) {
                res += query(1, N, 1, position.sparseIdx, 1);
                update(1, N, position.sparseIdx, 1);
            }

            sb.append(res).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Position {

        int x;
        int y;
        int sparseIdx = 1;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
