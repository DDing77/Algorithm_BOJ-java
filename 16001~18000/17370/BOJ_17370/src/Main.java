import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final int[][] dirs = {{-1, 0}, {1, 0}, {-1, 1}, {-1, -1}, {1, -1}, {1, 1}};
    private static final int[][] routers = {{2, 3}, {4, 5}, {0, 5}, {0, 4}, {1, 3}, {1, 2}};

    private int N;
    private boolean[][] isVisited;
    private int res;

    private void execDFS(int depth, int x, int y, int preDir) {

        if (depth == N) {
            if (isVisited[x][y]) {
                res++;
            }
            return;
        }

        if (isVisited[x][y]) {
            return;
        }

        isVisited[x][y] = true;
        execDFS(depth + 1, x + dirs[routers[preDir][0]][0], y + dirs[routers[preDir][0]][1], routers[preDir][0]);
        execDFS(depth + 1, x + dirs[routers[preDir][1]][0], y + dirs[routers[preDir][1]][1], routers[preDir][1]);
        isVisited[x][y] = false;
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        if (N < 5) {
            System.out.println(0);
            return;
        }

        isVisited = new boolean[46][46];
        isVisited[23][23] = true;
        execDFS(0, 22, 23, 0);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
