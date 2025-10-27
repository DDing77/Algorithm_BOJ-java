import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int N;
    private int M;
    private int[][] originBoard;
    private ArrayList<int[]> spaceList = new ArrayList<>();
    private int res;

    private int[][] copyBoard() {
        int[][] copyBoard = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyBoard[i][j] = originBoard[i][j];
            }
        }
        return copyBoard;
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        originBoard = new int[N][M];
        int totalCnt = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                originBoard[i][j] = line.charAt(j) - '0';
                if (originBoard[i][j] == 0) {
                    spaceList.add(new int[]{i, j});
                } else {
                    totalCnt++;
                }
            }
        }

        res = Integer.MAX_VALUE;

        for (int i = 0; i < spaceList.size() - 1; i++) {
            for (int j = i + 1; j < spaceList.size(); j++) {

                int[] aPos = spaceList.get(i);
                int[] bPos = spaceList.get(j);

                int[][] copyBoard = copyBoard();
                copyBoard[aPos[0]][aPos[1]] = 2;
                copyBoard[bPos[0]][bPos[1]] = 2;

                Queue<int[]> que = new ArrayDeque<>();
                que.add(aPos);
                que.add(bPos);

                int time = 0;
                int deleteCnt = 0;
                while (!que.isEmpty()) {
                    time++;
                    int queSize = que.size();
                    for (int k = 0; k < queSize; k++) {
                        int[] cur = que.poll();
                        for (int[] dir : dirs) {
                            int nX = cur[0] + dir[0];
                            int nY = cur[1] + dir[1];

                            if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                                continue;
                            }
                            if (copyBoard[nX][nY] == 2) {
                                continue;
                            }

                            if (copyBoard[nX][nY] == 1) {
                                deleteCnt++;
                            }

                            copyBoard[nX][nY] = 2;
                            que.add(new int[]{nX, nY});
                        }
                    }
                    if (deleteCnt == totalCnt) {
                        break;
                    }
                }

                res = Math.min(res, time);
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
