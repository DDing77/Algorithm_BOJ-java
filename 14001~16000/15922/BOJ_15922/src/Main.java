import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Coordinate[] coordinates;
    static int res;
    static int left;
    static int right;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        coordinates = new Coordinate[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            coordinates[i] = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(coordinates);
        res = 0;
        left = coordinates[0].x;
        right = coordinates[0].y;

        for (int i = 1; i < N; i++) {
            if (coordinates[i].x <= right) {
                right = Math.max(right, coordinates[i].y);
            } else {
                res += right - left;
                left = coordinates[i].x;
                right = coordinates[i].y;
            }
        }

        res += right - left;

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }

    static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coordinate o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }
}
