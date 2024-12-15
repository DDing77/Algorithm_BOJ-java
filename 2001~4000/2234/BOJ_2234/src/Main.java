import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    private int N;
    private int M;
    private int[][] board;
    private int[][] isVisited;
    private HashMap<Integer, Integer> groupMap;

    private int execBFS(int x, int y, int groupNumber) {

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});
        isVisited[x][y] = groupNumber;
        int sizeCnt = 1;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int i = 0; i < dir.length; i++) {
                int nX = cur[0] + dir[i][0];
                int nY = cur[1] + dir[i][1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }
                if (isVisited[nX][nY] == groupNumber) {
                    continue;
                }

                if ((board[cur[0]][cur[1]] & (1 << i)) == 0) {
                    sizeCnt++;
                    que.add(new int[]{nX, nY});
                    isVisited[nX][nY] = groupNumber;
                }
            }
        }

        return sizeCnt;
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isVisited = new int[N][M];
        int groupNumber = 1;
        int resMaxGroupSize = -1;
        groupMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isVisited[i][j] == 0) {
                    int size = execBFS(i, j, groupNumber);
                    groupMap.put(groupNumber++, size);
                    resMaxGroupSize = Math.max(resMaxGroupSize, size);
                }
            }
        }

        sb.append(groupMap.size()).append("\n")
                .append(resMaxGroupSize).append("\n");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < dir.length; k++) {
                    int nX = i + dir[k][0];
                    int nY = j + dir[k][1];

                    if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                        continue;
                    }
                    if (isVisited[i][j] == isVisited[nX][nY]) {
                        continue;
                    }

                    resMaxGroupSize = Math.max(resMaxGroupSize, groupMap.get(isVisited[i][j]) + groupMap.get(isVisited[nX][nY]));
                }
            }
        }
        sb.append(resMaxGroupSize);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
