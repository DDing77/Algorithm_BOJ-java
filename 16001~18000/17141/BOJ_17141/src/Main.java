import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    int N;
    int M;
    int[][] originMap;
    ArrayList<Virus> viruses;
    boolean[] isSelected;
    int[] selectedVirusIdx;
    int res;

    private int check(int[][] tempMap) {

        int resMax = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tempMap[i][j] == 0) {
                    return Integer.MAX_VALUE;
                } else if (tempMap[i][j] < 0) {
                    continue;
                }
                resMax = Math.max(resMax, tempMap[i][j]);
            }
        }

        return resMax;
    }

    private void execBFS(int[][] tempMap) {
        Queue<Virus> que = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[N][N];

        for (int i = 0; i < M; i++) {
            Virus virus = viruses.get(selectedVirusIdx[i]);
            que.add(virus);
            isVisited[virus.x][virus.y] = true;
            tempMap[virus.x][virus.y] = -2;
        }

        while (!que.isEmpty()) {
            Virus cur = que.poll();

            for (int i = 0; i < dir.length; i++) {
                int nX = cur.x + dir[i][0];
                int nY = cur.y + dir[i][1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= N) {
                    continue;
                }
                if (isVisited[nX][nY]) {
                    continue;
                }
                if (tempMap[nX][nY] < 0) {
                    continue;
                }

                que.add(new Virus(nX, nY, cur.count + 1));
                tempMap[nX][nY] = cur.count + 1;
                isVisited[nX][nY] = true;
            }
        }
    }

    private void backTracking(int depth, int start) {

        if (depth == M) {
            int[][] tempMap = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    tempMap[i][j] = originMap[i][j];
                }
            }
            execBFS(tempMap);
            res = Math.min(res, check(tempMap));
            return;
        }

        for (int i = start; i < viruses.size(); i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                selectedVirusIdx[depth] = i;
                backTracking(depth + 1, i + 1);
                isSelected[i] = false;
            }
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        originMap = new int[N][N];
        viruses = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if (cur == 2) {
                    viruses.add(new Virus(i, j, 0));
                } else if (cur == 1) {
                    originMap[i][j] = -1;
                } else {
                    originMap[i][j] = 0;
                }
            }
        }

        res = Integer.MAX_VALUE;
        isSelected = new boolean[viruses.size()];
        selectedVirusIdx = new int[M];

        backTracking(0, 0);

        if (res == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Virus {

        int x;
        int y;
        int count;

        public Virus(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
