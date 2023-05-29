import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// BFS 이용
//public class Main {
//    static int N;
//    static final int INF = 125 * 9 + 1;
//    static int[][] map;
//    static int[][] score;
//    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//
//    // bfs
//    static void solution() {
//        score[0][0] = map[0][0];
//        Queue<Integer> que = new LinkedList<>();
//        que.add(0);
//        que.add(0);
//
//        while(!que.isEmpty()) {
//            int x = que.poll();
//            int y = que.poll();
//
//            for(int k=0; k<4; k++) {
//                int nx = x + dir[k][0];
//                int ny = y + dir[k][1];
//                if(nx <0 || ny < 0 || nx >=N || ny >= N) continue;
//                if(score[nx][ny] <= score[x][y] + map[nx][ny]) continue;
//                score[nx][ny] = score[x][y] + map[nx][ny];
//                que.add(nx);
//                que.add(ny);
//            }
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int cnt = 1;
//        while (true) {
//            N = Integer.parseInt(br.readLine());
//            if (N == 0) {
//                System.out.println(sb);
//                return;
//            }
//
//            map = new int[N][N];
//            score = new int[N][N];
//
//            for (int i = 0; i < N; i++) {
//                String[] str = br.readLine().split(" ");
//                for (int j = 0; j < str.length; j++) {
//                    map[i][j] = Integer.parseInt(str[j]);
//                    score[i][j] = INF;
//                }
//            }
//
//            solution();
//            sb.append("Problem ").append(cnt).append(": ").append(score[N-1][N-1]).append('\n');
//            cnt++;
//        }
//    }
//}

// Dijkstra 이용
public class Main {
    static int N;
    static final int INF = 125 * 9 + 1;
    static int[][] map;
    static int[][] score;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static class Point {
        int x;
        int y;
        int value;
        public Point(int x, int y, int value) {
            this.x = x;
            this.y =y;
            this.value = value;
        }
    }

    static void solution() {
        score[0][0] = map[0][0];
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(o->o.value));
        pq.add(new Point(0,0,score[0][0]));

        while(!pq.isEmpty()) {
            Point cur = pq.poll();
            for(int k=0; k<4; k++) {
                int nx = cur.x + dir[k][0];
                int ny = cur.y + dir[k][1];
                if(nx <0 || ny < 0 || nx >=N || ny >= N) continue;
                if(score[nx][ny] <= score[cur.x][cur.y] + map[nx][ny]) continue;
                score[nx][ny] = score[cur.x][cur.y] + map[nx][ny];
                pq.add(new Point(nx,ny,score[nx][ny]));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                System.out.println(sb);
                return;
            }

            map = new int[N][N];
            score = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] str = br.readLine().split(" ");
                for (int j = 0; j < str.length; j++) {
                    map[i][j] = Integer.parseInt(str[j]);
                    score[i][j] = INF;
                }
            }

            solution();
            sb.append("Problem ").append(cnt).append(": ").append(score[N-1][N-1]).append('\n');
            cnt++;
        }
    }
}
