import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int MAX_SIZE = 1000;
    private static final int STONE_SIZE = 3;
    private int[] stones;
    private boolean[][] isVisited;

    private void solution() throws IOException {
        stones = new int[STONE_SIZE];

        int total = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < stones.length; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
            total += stones[i];
        }

        if (total % 3 != 0) {
            System.out.println(0);
            return;
        }

        Arrays.sort(stones);

        isVisited = new boolean[MAX_SIZE + 1][MAX_SIZE + 1];
        Queue<int[]> que = new ArrayDeque<>();
        isVisited[stones[0]][stones[1]] = true;
        que.add(stones);

        int target = total / 3;
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (isVisited[target][target]) {
                System.out.println(1);
                return;
            }

            for (int i = 0; i < 2; i++) {
                for (int j = i + 1; j < 3; j++) {
                    int[] nextStones = cur.clone();
                    nextStones[i] += cur[i];
                    nextStones[j] -= cur[i];
                    Arrays.sort(nextStones);

                    if (isVisited[nextStones[0]][nextStones[1]]) {
                        continue;
                    }

                    isVisited[nextStones[0]][nextStones[1]] = true;
                    que.add(nextStones);
                }
            }
        }

        System.out.println(0);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
