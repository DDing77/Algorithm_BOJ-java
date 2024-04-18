import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final int[][] dir = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, -1}, {2, 1}, {-1, -2}, {1, -2}};

    private void solution() throws IOException {

        String startStr = br.readLine();
        int startX = startStr.charAt(1) - '0' - 1;
        int startY = startStr.charAt(0) - 'a';

        String endStr = br.readLine();
        int endX = endStr.charAt(1) - '0' - 1;
        int endY = endStr.charAt(0) - 'a';

        boolean[][] isVisited = new boolean[8][8];
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{startX, startY, 0});
        isVisited[startX][startY] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[0] == endX && cur[1] == endY) {
                System.out.println(cur[2]);
                return;
            }

            for (int i = 0; i < dir.length; i++) {
                int nX = cur[0] + dir[i][0];
                int nY = cur[1] + dir[i][1];

                if (nX < 0 || nX >= 8 || nY < 0 || nY >= 8) {
                    continue;
                }
                if (isVisited[nX][nY]) {
                    continue;
                }

                que.add(new int[]{nX, nY, cur[2] + 1});
                isVisited[nX][nY] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
