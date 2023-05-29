import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Dot[] dots;

    public static int execCCW(Dot a, Dot b, Dot c) {
        int val = (a.x * b.y + b.x * c.y + c.x * a.y) - (a.x * c.y + b.x * a.y + c.x * b.y);

        if (val > 0) {
            return 1;
        } else if (val == 0) {
            return val;
        } else {
            return -1;
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        dots = new Dot[4];
        dots[0] = new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        dots[1] = new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        dots[2] = new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        dots[3] = new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        if ((execCCW(dots[0], dots[1], dots[2]) * execCCW(dots[0], dots[1], dots[3])) < 0 &&
                (execCCW(dots[2], dots[3], dots[0]) * execCCW(dots[2], dots[3], dots[1])) < 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }

    static class Dot {
        int x;
        int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
