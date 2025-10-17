import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int K;
    private Field field;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        field = new Field(N, M);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                field.valueBoard[i][j] = value;
            }
        }

        field.init();

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            int[] pos = field.harvest();
            sb.append(pos[0]).append(" ").append(pos[1]).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Field {
        int N;
        int M;
        boolean[][] isVisited;
        int[][] valueBoard;
        private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        PriorityQueue<Corn> posPQ = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);

        public Field(int n, int m) {
            N = n;
            M = m;
            isVisited = new boolean[N][M];
            valueBoard = new int[N][M];
        }

        public boolean isIn(int x, int y) {
            return 0 <= x && x < N && 0 <= y && y < M;
        }

        public void init() {
            for (int i = 0; i < N; i++) {
                if (!isVisited[i][0]) {
                    posPQ.add(new Corn(i, 0, valueBoard[i][0]));
                    isVisited[i][0] = true;
                }
                if (!isVisited[i][M - 1]) {
                    posPQ.add(new Corn(i, M - 1, valueBoard[i][M - 1]));
                    isVisited[i][M - 1] = true;
                }
            }

            for (int i = 0; i < M; i++) {
                if (!isVisited[0][i]) {
                    posPQ.add(new Corn(0, i, valueBoard[0][i]));
                    isVisited[0][i] = true;
                }
                if (!isVisited[N - 1][i]) {
                    posPQ.add(new Corn(N - 1, i, valueBoard[N - 1][i]));
                    isVisited[N - 1][i] = true;
                }
            }
        }

        public int[] harvest() {
            int[] pos = new int[2];

            Corn corn = posPQ.poll();
            pos[0] = corn.x + 1;
            pos[1] = corn.y + 1;

            for (int[] dir : dirs) {
                int nX = corn.x + dir[0];
                int nY = corn.y + dir[1];

                if (isIn(nX, nY) && !isVisited[nX][nY]) {
                    posPQ.add(new Corn(nX, nY, valueBoard[nX][nY]));
                    isVisited[nX][nY] = true;
                }
            }

            return pos;
        }
    }

    static class Corn {
        int x;
        int y;
        int value;

        public Corn(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
