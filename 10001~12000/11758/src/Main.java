import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static ArrayList<Point> points = new ArrayList<>();

    static int ccw(Point a, Point b, Point c) {
        long ccwR = (a.x * b.y + b.x * c.y + c.x * a.y) - (b.x * a.y + c.x * b.y + a.x * c.y);
        if (ccwR > 0) return 1;
        if (ccwR == 0) return 0;
        else return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points.add(new Point(x, y));
        }

        System.out.println(ccw(points.get(0), points.get(1), points.get(2)));
    }
}
