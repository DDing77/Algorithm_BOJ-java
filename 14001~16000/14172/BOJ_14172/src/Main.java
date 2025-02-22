import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private Cow[] cows;
    private boolean[] isVisited;
    private int res;

    private int execBFS(int startCowNumber) {
        Queue<Integer> que = new ArrayDeque<>();
        que.add(startCowNumber);

        isVisited = new boolean[N];
        isVisited[startCowNumber] = true;

        int transmitCount = 1;
        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int i = 0; i < N; i++) {
                if (!isVisited[i] && cows[cur].canTransmit(cows[i])) {
                    isVisited[i] = true;
                    que.add(i);
                    transmitCount++;
                }
            }
        }

        return transmitCount;
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        cows = new Cow[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cows[i] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < N; i++) {
            res = Math.max(res, execBFS(i));
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Cow {

        int x;
        int y;
        int p;

        public Cow(int x, int y, int p) {
            this.x = x;
            this.y = y;
            this.p = p;
        }

        public boolean canTransmit(Cow cow) {
            return Math.pow(this.x - cow.x, 2) + Math.pow(this.y - cow.y, 2) <= Math.pow(this.p, 2);
        }
    }
}
