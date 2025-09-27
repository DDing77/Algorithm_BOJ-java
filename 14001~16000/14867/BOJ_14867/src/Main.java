import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int a;
    private int b;
    private int c;
    private int d;
    private HashMap<Integer, Set<Integer>> map = new HashMap<>();
    private int res = -1;

    private int[] fillBottle(int[] bottles, int x) {
        if (x == 0) {
            return new int[]{a, bottles[1]};
        }
        return new int[]{bottles[0], b};
    }

    private int[] emptyBottle(int[] bottles, int x) {
        if (x == 0) {
            return new int[]{0, bottles[1]};
        }
        return new int[]{bottles[0], 0};
    }

    private int[] moveAB(int[] bottles) {
        if (bottles[0] <= b - bottles[1]) {
            return new int[]{0, bottles[1] + bottles[0]};
        }
        return new int[]{bottles[0] - (b - bottles[1]), b};
    }

    private int[] moveBA(int[] bottles) {
        if (bottles[1] <= a - bottles[0]) {
            return new int[]{bottles[1] + bottles[0], 0};
        }
        return new int[]{a, bottles[1] - (a - bottles[0])};
    }

    private void check(Queue<int[]> que, int[] cur, int[] moveBARes) {
        if (!map.containsKey(moveBARes[0])) {
            map.computeIfAbsent(moveBARes[0], K -> new HashSet<>()).add(moveBARes[1]);
            que.add(new int[]{moveBARes[0], moveBARes[1], cur[2] + 1});
        } else if (!map.get(moveBARes[0]).contains(moveBARes[1])) {
            map.get(moveBARes[0]).add(moveBARes[1]);
            que.add(new int[]{moveBARes[0], moveBARes[1], cur[2] + 1});
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{0, 0, 0});
        map.computeIfAbsent(0, K -> new HashSet<>()).add(0);

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[0] == c && cur[1] == d) {
                res = cur[2];
                break;
            }

            for (int i = 0; i < 2; i++) {
                int[] fillRes = fillBottle(cur, i);
                check(que, cur, fillRes);

                int[] emptyRes = emptyBottle(cur, i);
                check(que, cur, emptyRes);
            }

            int[] moveABRes = moveAB(cur);
            check(que, cur, moveABRes);

            int[] moveBARes = moveBA(cur);
            check(que, cur, moveBARes);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
