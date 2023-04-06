import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public class Location {
        int floor;
        int cnt;

        public Location(int floor, int cnt) {
            this.floor = floor;
            this.cnt = cnt;
        }
    }

    private int[] dir;
    private int F, S, G, U, D;
    private int res;

    public void bfs() {
        boolean[] isVisited = new boolean[F + 1];
        Queue<Location> que = new LinkedList<>();
        que.add(new Location(S, 0));
        isVisited[S] = true;

        while (!que.isEmpty()) {
            Location cur = que.poll();

            if (cur.floor == G) {
                res = cur.cnt;
            }

            for (int k = 0; k < dir.length; k++) {
                int newFloor = cur.floor + dir[k];

                if (newFloor < 1 || newFloor > F) {
                    continue;
                }

                if (isVisited[newFloor]) {
                    continue;
                }

                que.add(new Location(newFloor, cur.cnt + 1));
                isVisited[newFloor] = true;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        dir = new int[2];
        dir[0] = U;
        dir[1] = -D;

        if (S == G) {
            System.out.println(0);
            return;
        }

        res = -1;
        bfs();

        if (res == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(res);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
