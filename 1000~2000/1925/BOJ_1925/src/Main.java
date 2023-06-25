import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final String[] message = {"X", "JungTriangle", "Dunkak2Triangle", "Jikkak2Triangle", "Yeahkak2Triangle", "DunkakTriangle", "JikkakTriangle", "YeahkakTriangle"};
    static Coordinate[] coordinates;

    public static int getVector(int x1, int y1, int x2, int y2) {
        return x1 * x2 + y1 * y2;
    }

    public static boolean isParallel() {
        int dyAB = coordinates[1].y - coordinates[0].y;
        int dxAB = coordinates[1].x - coordinates[0].x;
        int dyAC = coordinates[2].y - coordinates[0].y;
        int dxAC = coordinates[2].x - coordinates[0].x;

        if (dyAB * dxAC == dxAB * dyAC) {
            return true;
        }
        return false;
    }

    public static boolean isThreeLine() {
        double AB = Math.pow(coordinates[0].x - coordinates[1].x, 2) + Math.pow(coordinates[0].y - coordinates[1].y, 2);
        double BC = Math.pow(coordinates[1].x - coordinates[2].x, 2) + Math.pow(coordinates[1].y - coordinates[2].y, 2);
        double AC = Math.pow(coordinates[0].x - coordinates[2].x, 2) + Math.pow(coordinates[0].y - coordinates[2].y, 2);

        if (AB == BC && BC == AC) {
            return true;
        }
        return false;
    }

    public static boolean isTwoLine() {
        double AB = Math.pow(coordinates[0].x - coordinates[1].x, 2) + Math.pow(coordinates[0].y - coordinates[1].y, 2);
        double BC = Math.pow(coordinates[1].x - coordinates[2].x, 2) + Math.pow(coordinates[1].y - coordinates[2].y, 2);
        double AC = Math.pow(coordinates[0].x - coordinates[2].x, 2) + Math.pow(coordinates[0].y - coordinates[2].y, 2);

        if (AB == BC || BC == AC || AB == AC) {
            return true;
        }
        return false;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        coordinates = new Coordinate[3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            coordinates[i] = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        if (isParallel()) {
            System.out.println(message[0]);
        } else if (isThreeLine()) {
            System.out.println(message[1]);
        } else if (isTwoLine()) {
            if (getVector(coordinates[1].x - coordinates[0].x, coordinates[1].y - coordinates[0].y, coordinates[2].x - coordinates[0].x, coordinates[2].y - coordinates[2].y) < 0 ||
                    getVector(coordinates[0].x - coordinates[1].x, coordinates[0].y - coordinates[1].y, coordinates[2].x - coordinates[1].x, coordinates[2].y - coordinates[1].y) < 0 ||
                    getVector(coordinates[0].x - coordinates[2].x, coordinates[0].y - coordinates[2].y, coordinates[1].x - coordinates[2].x, coordinates[1].y - coordinates[2].y) < 0) {
                System.out.println(message[2]);
            } else if (getVector(coordinates[1].x - coordinates[0].x, coordinates[1].y - coordinates[0].y, coordinates[2].x - coordinates[0].x, coordinates[2].y - coordinates[2].y) == 0 ||
                    getVector(coordinates[0].x - coordinates[1].x, coordinates[0].y - coordinates[1].y, coordinates[2].x - coordinates[1].x, coordinates[2].y - coordinates[1].y) == 0 ||
                    getVector(coordinates[0].x - coordinates[2].x, coordinates[0].y - coordinates[2].y, coordinates[1].x - coordinates[2].x, coordinates[1].y - coordinates[2].y) == 0) {
                System.out.println(message[3]);
            } else {
                System.out.println(message[4]);
            }
        } else {
            if (getVector(coordinates[1].x - coordinates[0].x, coordinates[1].y - coordinates[0].y, coordinates[2].x - coordinates[0].x, coordinates[2].y - coordinates[2].y) < 0 ||
                    getVector(coordinates[0].x - coordinates[1].x, coordinates[0].y - coordinates[1].y, coordinates[2].x - coordinates[1].x, coordinates[2].y - coordinates[1].y) < 0 ||
                    getVector(coordinates[0].x - coordinates[2].x, coordinates[0].y - coordinates[2].y, coordinates[1].x - coordinates[2].x, coordinates[1].y - coordinates[2].y) < 0) {
                System.out.println(message[5]);
            } else if (getVector(coordinates[1].x - coordinates[0].x, coordinates[1].y - coordinates[0].y, coordinates[2].x - coordinates[0].x, coordinates[2].y - coordinates[2].y) == 0 ||
                    getVector(coordinates[0].x - coordinates[1].x, coordinates[0].y - coordinates[1].y, coordinates[2].x - coordinates[1].x, coordinates[2].y - coordinates[1].y) == 0 ||
                    getVector(coordinates[0].x - coordinates[2].x, coordinates[0].y - coordinates[2].y, coordinates[1].x - coordinates[2].x, coordinates[1].y - coordinates[2].y) == 0) {
                System.out.println(message[6]);
            } else {
                System.out.println(message[7]);
            }
        }
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
