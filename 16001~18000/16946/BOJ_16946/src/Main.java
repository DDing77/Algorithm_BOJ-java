import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int N;
    int M;
    char[][] board;
    int groupNumber;
    int[][] groupMap;
    int[] groupValue;

    public int execBFS(int x, int y) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});
        groupMap[x][y] = groupNumber;

        int cnt = 1;
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int i = 0; i < dir.length; i++) {
                int nX = cur[0] + dir[i][0];
                int nY = cur[1] + dir[i][1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }
                if (board[nX][nY] == '1') {
                    continue;
                }
                if (groupMap[nX][nY] != 0) {
                    continue;
                }

                que.add(new int[]{nX, nY});
                cnt++;
                groupMap[nX][nY] = groupNumber;
            }
        }
        return cnt;
    }

    public int getCount(int x, int y) {
        int cnt = 1;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < dir.length; i++) {
            int nX = x + dir[i][0];
            int nY = y + dir[i][1];

            if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                continue;
            }
            if (board[nX][nY] == '1') {
                continue;
            }
            if (groupMap[nX][nY] == 0) {
                continue;
            }

            if(set.contains(groupMap[nX][nY])) {
                continue;
            }

            set.add(groupMap[nX][nY]);
            cnt += groupValue[groupMap[nX][nY]];
        }

        return cnt % 10;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        groupMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        groupValue = new int[N * M + 1];
        groupNumber = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == '0' && groupMap[i][j] == 0) {
                    groupValue[groupNumber] = execBFS(i, j);
                    groupNumber++;
                }
            }
        }
//
//        for (int group : groups.keySet()) {
//            System.out.println(group + " , " + groups.get(group));
//        }
//
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(groupMap[i]));
//        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == '0') {
                    sb.append(0);
                } else {
                    sb.append(getCount(i, j));
                }
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
