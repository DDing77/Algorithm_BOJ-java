import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N, K;
    static int S, X, Y;
    static int[][] map;
    static PriorityQueue<Virus> pq;

    static class Virus {
        private int r;
        private int c;
        private int value;

        public Virus(int r, int c, int value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public int getValue() {
            return value;
        }
    }

    static int bfs() {
        List<Virus> list = new ArrayList<>();

        while (!pq.isEmpty()) {
            Virus cur = pq.poll();

            for (int k = 0; k < 4; k++) {
                int nX = cur.getR() + dir[k][0];
                int nY = cur.getC() + dir[k][1];
                if (nX <= 0 || nX > N || nY <= 0 || nY > N) continue;
                if (map[nX][nY] != 0) continue;

                map[nX][nY] = cur.getValue();
                list.add(new Virus(nX, nY, map[nX][nY]));

            }
            if (pq.size() == 0) {
                S--;
                if (S == 0) return map[X][Y];
                pq.addAll(list);
                list.clear();
            }
        }
        return map[X][Y];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 0) continue;
                map[i][j] = value;
                pq.add(new Virus(i, j, map[i][j]));
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        if (S == 0) {
            System.out.println(map[X][Y]);
            return;
        }

        System.out.println(bfs());
    }
}
