import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static int[][] dirs = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    private int N;
    private int M;
    private int K;
    private Queue<FireBall> aliveFireBalls;
    private Map<Integer, List<FireBall>> mapBoard;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        aliveFireBalls = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            aliveFireBalls.add(new FireBall(x, y, m, s, d));
        }

        while (K-- > 0) {
            mapBoard = new HashMap<>();
            while (!aliveFireBalls.isEmpty()) {
                FireBall fireBall = aliveFireBalls.poll();
                fireBall.move(N);
                int idx = fireBall.x * N + fireBall.y;

                mapBoard.computeIfAbsent(idx, k -> new ArrayList<>()).add(fireBall);
            }

            for (List<FireBall> balls : mapBoard.values()) {
                if (balls.size() == 1) {
                    aliveFireBalls.add(balls.get(0));
                    continue;
                }

                int mSum = 0;
                int sSum = 0;
                int even = 0;
                int odd = 0;

                for (FireBall fireBall : balls) {
                    mSum += fireBall.m;
                    sSum += fireBall.s;
                    if (fireBall.dirIdx % 2 == 0) {
                        even++;
                    } else {
                        odd++;
                    }
                }

                int nextM = mSum / 5;
                if (nextM == 0) {
                    continue;
                }

                int nextS = sSum / balls.size();
                int x = balls.get(0).x;
                int y = balls.get(0).y;

                if (even == balls.size() || odd == balls.size()) {
                    aliveFireBalls.add(new FireBall(x, y, nextM, nextS, 0));
                    aliveFireBalls.add(new FireBall(x, y, nextM, nextS, 2));
                    aliveFireBalls.add(new FireBall(x, y, nextM, nextS, 4));
                    aliveFireBalls.add(new FireBall(x, y, nextM, nextS, 6));
                } else {
                    aliveFireBalls.add(new FireBall(x, y, nextM, nextS, 1));
                    aliveFireBalls.add(new FireBall(x, y, nextM, nextS, 3));
                    aliveFireBalls.add(new FireBall(x, y, nextM, nextS, 5));
                    aliveFireBalls.add(new FireBall(x, y, nextM, nextS, 7));
                }
            }
        }

        int res = 0;
        while (!aliveFireBalls.isEmpty()) {
            FireBall fireBall = aliveFireBalls.poll();
            res += fireBall.m;
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class FireBall {

        int x;
        int y;
        int m;
        int s;
        int dirIdx;

        public FireBall(int x, int y, int m, int s, int dirIdx) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.s = s;
            this.dirIdx = dirIdx;
        }

        public void move(int N) {
            int moveDist = s % N;
            x = (x + dirs[dirIdx][0] * moveDist + N) % N;
            y = (y + dirs[dirIdx][1] * moveDist + N) % N;
        }
    }
}
