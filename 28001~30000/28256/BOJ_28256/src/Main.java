import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int T;
    char[][] board;
    ArrayList<Integer> connectedNumbers;
    ArrayList<Integer> foundedGroup;
    boolean[][] isVisited;

    public int execBFS(int x, int y) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});
        isVisited[x][y] = true;

        int cnt = 1;
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int i = 0; i < dir.length; i++) {
                int nX = cur[0] + dir[i][0];
                int nY = cur[1] + dir[i][1];

                if (nX < 0 || nX >= 3 || nY < 0 || nY >= 3) {
                    continue;
                }
                if (isVisited[nX][nY]) {
                    continue;
                }
                if (board[nX][nY] != 'O') {
                    continue;
                }

                que.add(new int[]{nX, nY});
                isVisited[nX][nY] = true;
                cnt++;
            }
        }
        return cnt;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            board = new char[3][3];
            for (int i = 0; i < 3; i++) {
                board[i] = br.readLine().toCharArray();
            }

            connectedNumbers = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            while (size-- > 0) {
                connectedNumbers.add(Integer.parseInt(st.nextToken()));
            }

            foundedGroup = new ArrayList<>();
            isVisited = new boolean[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == 'O' && !isVisited[i][j]) {
                        foundedGroup.add(execBFS(i, j));
                    }
                }
            }
            Collections.sort(foundedGroup);

            boolean isAllMatching = true;
            if (foundedGroup.size() != connectedNumbers.size()) {
                sb.append(0).append('\n');
                continue;
            }

            for (int i = 0; i < connectedNumbers.size(); i++) {
                if (foundedGroup.get(i) != connectedNumbers.get(i)) {
                    isAllMatching = false;
                    break;
                }
            }

            if (!isAllMatching) {
                sb.append(0).append('\n');
            } else {
                sb.append(1).append('\n');
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
