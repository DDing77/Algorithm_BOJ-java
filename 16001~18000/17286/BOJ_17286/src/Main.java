import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Coordinate[] coordinates;
    static boolean[] isVisited;
    static int res;

    public static double getDistance(Coordinate a, Coordinate b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    public static void execDFS(int next, int depth, double sum) {
        if (depth == 4) {
            res = (int) Math.min(res, sum);
        }

        for (int i = 0; i < 4; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                execDFS(i, depth + 1, sum + getDistance(coordinates[next], coordinates[i]));
                isVisited[i] = false;
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        coordinates = new Coordinate[4];
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            coordinates[i] = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        res = Integer.MAX_VALUE;
        isVisited = new boolean[4];
        execDFS(0, 0, 0);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
