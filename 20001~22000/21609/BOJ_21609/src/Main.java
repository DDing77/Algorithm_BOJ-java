import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int N;
    private int M;
    private int[][] board;
    private boolean[][] isVisited;
    private int res;

    private BlockGroup execBFS(int x, int y) {
        int rainbowBlockCount = 0;
        List<int[]> log = new ArrayList<>();
        List<int[]> rainbowBlock = new ArrayList<>();

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});
        log.add(new int[]{x, y});
        isVisited[x][y] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int[] dir : dirs) {
                int nX = cur[0] + dir[0];
                int nY = cur[1] + dir[1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= N) continue;
                if (isVisited[nX][nY]) continue;
                if (board[nX][nY] == -1) continue;

                if (board[nX][nY] == 0) {
                    rainbowBlockCount++;
                    rainbowBlock.add(new int[]{nX, nY});
                    que.add(new int[]{nX, nY});
                    log.add(new int[]{nX, nY});
                    isVisited[nX][nY] = true;
                } else if (board[nX][nY] == board[x][y]) {
                    que.add(new int[]{nX, nY});
                    log.add(new int[]{nX, nY});
                    isVisited[nX][nY] = true;
                }
            }
        }

        for (int[] coordi : rainbowBlock) {
            isVisited[coordi[0]][coordi[1]] = false;
        }

        int standardX = N;
        int standardY = N;
        for (int[] block : log) {
            int bx = block[0];
            int by = block[1];
            if (board[bx][by] != 0) {
                if (bx < standardX || (bx == standardX && by < standardY)) {
                    standardX = bx;
                    standardY = by;
                }
            }
        }

        return new BlockGroup(standardX, standardY, board[x][y], rainbowBlockCount, log);
    }

    private List<BlockGroup> findBlockGroup() {
        List<BlockGroup> blockGroups = new ArrayList<>();
        isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] > 0 && !isVisited[i][j]) {
                    BlockGroup blockGroup = execBFS(i, j);

                    if (blockGroup.blocks.size() > 1) {
                        blockGroups.add(blockGroup);
                    }
                }
            }
        }

        return blockGroups;
    }

    private int removeBlockGroup(BlockGroup blockGroup) {
        for (int[] block : blockGroup.blocks) {
            board[block[0]][block[1]] = -2;
        }
        return blockGroup.blocks.size() * blockGroup.blocks.size();
    }

    private void downBlock() {
        for (int j = 0; j < N; j++) {
            for (int i = N - 2; i >= 0; i--) {
                if (board[i][j] >= 0) {
                    int curX = i;
                    while (true) {
                        if (curX + 1 >= N) break;
                        if (board[curX + 1][j] != -2) break;
                        curX++;
                    }
                    if (i != curX) {
                        board[curX][j] = board[i][j];
                        board[i][j] = -2;
                    }
                }
            }
        }
    }

    private void rotateBoard() {
        int[][] tempBoard = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tempBoard[i][j] = board[j][N - i - 1];
            }
        }
        board = tempBoard;
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            List<BlockGroup> blockGroupList = findBlockGroup();

            if (blockGroupList.isEmpty()) break;

            Collections.sort(blockGroupList);
            BlockGroup blockGroup = blockGroupList.get(0);

            res += removeBlockGroup(blockGroup);

            downBlock();
            rotateBoard();
            downBlock();
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static class BlockGroup implements Comparable<BlockGroup> {
        int startX, startY, color, rainbowBlockCount;
        List<int[]> blocks;

        public BlockGroup(int startX, int startY, int color, int rainbowBlockCount, List<int[]> blocks) {
            this.startX = startX;
            this.startY = startY;
            this.color = color;
            this.rainbowBlockCount = rainbowBlockCount;
            this.blocks = blocks;
        }

        @Override
        public int compareTo(BlockGroup o) {
            if (this.blocks.size() != o.blocks.size()) {
                return o.blocks.size() - this.blocks.size();
            }
            if (this.rainbowBlockCount != o.rainbowBlockCount) {
                return o.rainbowBlockCount - this.rainbowBlockCount;
            }
            if (this.startX != o.startX) {
                return o.startX - this.startX;
            }
            return o.startY - this.startY;
        }
    }
}
