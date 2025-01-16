import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int N;
    private int M;
    private int[][] board;
    private boolean[][] isVisited;
    private int groupNumber;
    private HashMap<Integer, Group> groupInfo;
    private Set<Integer> totalCandidates;
    private int[] arrTotalCandidates;
    private int res;

    private void execDFS(int depth, int curIdx) {

        if ((totalCandidates.size() == 1 && depth == 1) || depth == 2) {

            int sum = 0;
            for (int i = 1; i < groupNumber; i++) {
                boolean flag = true;
                for (int candidate : groupInfo.get(i).candidates) {
                    if (board[candidate / M][candidate % M] != 1) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    sum += groupInfo.get(i).type2Size;
                }
            }

            res = Math.max(res, sum);
            return;
        }

        for (int i = curIdx; i < arrTotalCandidates.length; i++) {
            int pos = arrTotalCandidates[i];
            if (board[pos / M][pos % M] != 1) {
                board[pos / M][pos % M] = 1;
                execDFS(depth + 1, i + 1);
                board[pos / M][pos % M] = 0;
            }
        }
    }

    private void execBFS(int x, int y) {

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});
        isVisited[x][y] = true;

        Set<Integer> candi = new HashSet<>();
        int type2Cnt = 1;
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int[] dir : dirs) {
                int nX = cur[0] + dir[0];
                int nY = cur[1] + dir[1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }
                if (isVisited[nX][nY]) {
                    continue;
                }

                if (board[nX][nY] == 0) {
                    candi.add(nX * M + nY);
                } else if (board[nX][nY] == 2) {
                    type2Cnt++;
                    isVisited[nX][nY] = true;
                    que.add(new int[]{nX, nY});
                }
            }
        }

        if (candi.size() <= 2) {
            groupInfo.put(groupNumber, new Group(groupNumber, type2Cnt));
            for (int pos : candi) {
                groupInfo.get(groupNumber).candidates.add(pos);
            }
            groupNumber++;
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        groupInfo = new HashMap<>();
        isVisited = new boolean[N][M];
        groupNumber = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 2 && !isVisited[i][j]) {
                    execBFS(i, j);
                }
            }
        }

        totalCandidates = new HashSet<>();
        for (Map.Entry<Integer, Group> entry : groupInfo.entrySet()) {
            totalCandidates.addAll(entry.getValue().candidates);
        }

        arrTotalCandidates = new int[totalCandidates.size()];
        int idx = 0;
        for (int totalCandidate : totalCandidates) {
            arrTotalCandidates[idx++] = totalCandidate;
        }

        execDFS(0, 0);
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Group {

        int groupNumber;
        Set<Integer> candidates;
        int type2Size;

        public Group(int groupNumber, int type2Size) {
            this.groupNumber = groupNumber;
            this.candidates = new HashSet<>();
            this.type2Size = type2Size;
        }
    }
}
