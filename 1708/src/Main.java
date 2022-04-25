import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;

    static class Point {
        long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static ArrayList<Point> points;
    static Point root = new Point(Long.MAX_VALUE, Long.MAX_VALUE);

    static int grahamScan(ArrayList<Point> input) {
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).y < root.y) root = input.get(i);
            else if (input.get(i).y == root.y) {
                if (input.get(i).x < root.x) root = input.get(i);
            }
        }

        input.sort(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                int result = ccw(root, p1, p2);

                if (result > 0) return -1;
                else if (result < 0) return 1;
                else {
                    long distance1 = dist(root, p1);
                    long distance2 = dist(root, p2);

                    if (distance1 > distance2) return 1;
                }
                return -1;
            }
        });

        Stack<Point> stack = new Stack<>();
        stack.add(root);

        for (int i = 1; i < input.size(); i++) {
            while (stack.size() > 1 && (ccw(stack.get(stack.size() - 2), stack.get(stack.size() - 1), input.get(i)) <= 0)) {
                stack.pop();
            }
            stack.add(input.get(i));
        }
        return stack.size();
    }

    static long dist(Point a, Point b) {
        return (b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y);
    }

    static int ccw(Point a, Point b, Point c) {
        long ccwR = (a.x * b.y + b.x * c.y + c.x * a.y) - (b.x * a.y + c.x * b.y + a.x * c.y);
        if (ccwR > 0) return 1;
        if (ccwR == 0) return 0;
        else return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        points = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points.add(new Point(x, y));
        }

        int res = grahamScan(points);

        System.out.println(res);
    }
}
