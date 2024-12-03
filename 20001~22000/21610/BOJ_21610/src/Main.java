import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[][] dir = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

    private int N;
    private int M;
    private int[][] buckets;
    private boolean[][] cached;
    private int d;
    private int s;

    private ArrayList<Cloud> searchNewClouds() {

        ArrayList<Cloud> nextCloudList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (buckets[i][j] >= 2 && !cached[i][j]) {
                    nextCloudList.add(new Cloud(i, j));
                    buckets[i][j] -= 2;
                }
            }
        }

        return nextCloudList;
    }

    private void move(ArrayList<Cloud> cloudList, int N, int d, int s) {

        cached = new boolean[N][N];
        for (Cloud cloud : cloudList) {
            cloud = cloud.move(N, d, s);
            buckets[cloud.x][cloud.y]++;
            cached[cloud.x][cloud.y] = true;
        }
    }

    private void duplicate(ArrayList<Cloud> cloudList) {

        for (Cloud cloud : cloudList) {
            cloud.dup(N, buckets);
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        buckets = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                buckets[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayList<Cloud> cloudList = new ArrayList<>();
        cloudList.add(new Cloud(N - 2, 0));
        cloudList.add(new Cloud(N - 2, 1));
        cloudList.add(new Cloud(N - 1, 0));
        cloudList.add(new Cloud(N - 1, 1));

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken()) - 1;
            s = Integer.parseInt(st.nextToken());

            cached = new boolean[N][N];
            move(cloudList, N, d, s);
            duplicate(cloudList);
            cloudList = searchNewClouds();
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += buckets[i][j];
            }
        }

        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Cloud {

        int x;
        int y;

        public Cloud(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Cloud move(int N, int d, int s) {

            int nX = x + dir[d][0] * s;
            int nY = y + dir[d][1] * s;

            if (nX < 0) {
                nX = (N - (nX * -1) % N) % N;
            } else if (nX >= N) {
                nX %= N;
            }

            if (nY < 0) {
                nY = (N - (nY * -1) % N) % N;
            } else if (nY >= N) {
                nY %= N;
            }

            x = nX;
            y = nY;
            return this;
        }

        public void dup(int N, int[][] buckets) {

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 || j == 0) {
                        continue;
                    }

                    int nX = this.x + i;
                    int nY = this.y + j;

                    if (nX < 0 || nX >= N || nY < 0 || nY >= N) {
                        continue;
                    }

                    if (buckets[nX][nY] > 0) {
                        buckets[this.x][this.y]++;
                    }
                }
            }
        }
    }
}
