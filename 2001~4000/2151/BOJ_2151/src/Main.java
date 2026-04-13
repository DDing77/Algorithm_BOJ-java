import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private static final int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private int N;
    private char[][] board;
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    private int execBFS() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][][] isVisited = new boolean[N][N][4];

        for (int i = 0; i < 4; i++) {
            pq.add(new Node(startX, startY, 0, i));
            isVisited[startX][startY][i] = true;
        }

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (curNode.x == endX && curNode.y == endY) {
                return curNode.cnt;
            }

            int nX = curNode.x + dirs[curNode.dirIdx][0];
            int nY = curNode.y + dirs[curNode.dirIdx][1];

            if (nX < 0 || nX >= N || nY < 0 || nY >= N) {
                continue;
            }
            if (board[nX][nY] == '*') {
                continue;
            }

            if (!isVisited[nX][nY][curNode.dirIdx]) {
                isVisited[nX][nY][curNode.dirIdx] = true;
                pq.add(new Node(nX, nY, curNode.cnt, curNode.dirIdx));
            }

            if (board[nX][nY] == '!') {
                int leftDirIdx = (curNode.dirIdx + 3) % 4;
                if (!isVisited[nX][nY][leftDirIdx]) {
                    isVisited[nX][nY][leftDirIdx] = true;
                    pq.add(new Node(nX, nY, curNode.cnt + 1, leftDirIdx));
                }

                int rightDirIdx = (curNode.dirIdx + 1) % 4;
                if (!isVisited[nX][nY][rightDirIdx]) {
                    isVisited[nX][nY][rightDirIdx] = true;
                    pq.add(new Node(nX, nY, curNode.cnt + 1, rightDirIdx));
                }
            }
        }

        return 0;
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        boolean isStartDoor = true;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == '#') {
                    if (isStartDoor) {
                        startX = i;
                        startY = j;
                        isStartDoor = false;
                    } else {
                        endX = i;
                        endY = j;
                    }
                }
            }
        }

        System.out.println(execBFS());
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cnt;
        int dirIdx;

        public Node(int x, int y, int cnt, int dirIdx) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dirIdx = dirIdx;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cnt, o.cnt);
        }
    }
}