import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int CCW(Coordinate a, Coordinate b, Coordinate c) {
        long temp = a.x * b.y + b.x * c.y + a.y * c.x;
        temp -= a.y * b.x;
        temp -= b.y * c.x;
        temp -= a.x * c.y;
        return temp < 0 ? 1 : -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        Coordinate A = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Coordinate B = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        Coordinate C = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Coordinate D = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        if (CCW(A, B, C) * CCW(A, B, D) < 0 && CCW(C, D, A) * CCW(C, D, B) < 0) System.out.println("1");
        else System.out.println("0");
    }
}
