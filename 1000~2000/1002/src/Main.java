import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static Circle[] circles;

    private static int getResult(Circle c1, Circle c2) {
        int xDistance = (c1.x >= c2.x) ? c1.x - c2.x : c2.x - c1.x;
        int yDistance = (c1.y >= c2.y) ? c1.y - c2.y : c2.y - c1.y;

        if (xDistance == 0 && yDistance == 0) {
            if (c1.r == c2.r && c1.r == 0) {
                return 1;
            } else if (c1.r == c2.r) {
                return -1;
            } else {
                return 0;
            }
        }

        double distance;
        if (xDistance == 0) {
            distance = yDistance;
        } else if (yDistance == 0) {
            distance = xDistance;
        } else {
            distance = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
        }

        if (distance == c1.r + c2.r) {
            return 1;
        } else if (distance > c1.r + c2.r) {
            return 0;
        } else {
            if (c1.r == c2.r) {
                return 2;
            }

            int bigger = Math.max(c1.r, c2.r);
            int smaller = Math.min(c1.r, c2.r);

            if (bigger - distance > smaller) {
                return 0;
            } else if (bigger - distance == smaller) {
                return 1;
            } else {
                return 2;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            circles = new Circle[2];

            st = new StringTokenizer(br.readLine());
            circles[0] = new Circle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            circles[1] = new Circle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            sb.append(getResult(circles[0], circles[1])).append('\n');
        }

        System.out.println(sb);
    }

    static class Circle {
        int x;
        int y;
        int r;

        public Circle(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }
}