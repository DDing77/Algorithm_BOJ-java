import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int LIMIT = 1 << 10;

    private String strL;
    private int L;
    private int K;
    private boolean[] isVisited;

    private void solution() throws IOException {
        strL = br.readLine();
        L = Integer.parseInt(strL, 2);
        K = Integer.parseInt(br.readLine(), 2);

        if (L == K) {
            System.out.println(0);
            return;
        }

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{L, 0});
        isVisited = new boolean[LIMIT];
        isVisited[L] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            if (cur[0] == K) {
                System.out.println(cur[1]);
                return;
            }

            int next;
            int length = Integer.toBinaryString(cur[0]).length();
            for (int i = 0; i < length - 1; i++) {
                next = cur[0] ^ (1 << i);
                if (!isVisited[next]) {
                    que.add(new int[]{next, cur[1] + 1});
                    isVisited[next] = true;
                }
            }

            next = cur[0] + 1;
            if (next < LIMIT && !isVisited[next]) {
                que.add(new int[]{next, cur[1] + 1});
                isVisited[next] = true;
            }

            next = cur[0] - 1;
            if (0 <= next && !isVisited[next]) {
                que.add(new int[]{next, cur[1] + 1});
                isVisited[next] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
