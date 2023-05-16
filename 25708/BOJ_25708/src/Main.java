public class Main {

    private int N;
    private int M;
    private int[][] map;
    private int res;

    public void solution() throws Exception {
        N = read();
        M = read();

        map = new int[N + 1][M + 1];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                map[r][c] = read();
                map[r][M] += map[r][c];
                map[N][c] += map[r][c];
            }
        }

        res = Integer.MIN_VALUE;
        for (int r1 = 0; r1 < N - 1; r1++) {
            for (int c1 = 0; c1 < M - 1; c1++) {
                for (int r2 = r1 + 1; r2 < N; r2++) {
                    for (int c2 = c1 + 1; c2 < M; c2++) {
                        res = Math.max(res,
                                map[r1][M] + map[r2][M] + map[N][c1] + map[N][c2]
                                        - map[r1][c1] - map[r1][c2] - map[r2][c1] - map[r2][c2]
                                        + (r2 - r1 - 1) * (c2 - c1 - 1));
                    }
                }
            }
        }

        System.out.println(res);
    }

    public int read() throws Exception {

        int c;
        int n = System.in.read() & 15;

        boolean isNegative = n == 13;

        if (isNegative) n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return isNegative ? ~n + 1 : n;

    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
