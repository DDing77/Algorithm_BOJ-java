import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final String[] message = {"POINT", "LINE", "FACE", "NULL"};
    static Rectangle[] rectangles;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        rectangles = new Rectangle[2];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            rectangles[i] = new Rectangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        if (rectangles[0].x1 == rectangles[1].x2 && rectangles[0].y1 == rectangles[1].y2 ||
                rectangles[0].x2 == rectangles[1].x1 && rectangles[0].y2 == rectangles[1].y1 ||
                rectangles[0].x1 == rectangles[1].x2 && rectangles[0].y2 == rectangles[1].y1 ||
                rectangles[0].x2 == rectangles[1].x1 && rectangles[0].y1 == rectangles[1].y2) {
            System.out.println(message[0]);
        } else if (rectangles[0].x1 > rectangles[1].x2 || rectangles[0].x2 < rectangles[1].x1 ||
                rectangles[0].y2 < rectangles[1].y1 || rectangles[0].y1 > rectangles[1].y2) {
            System.out.println(message[3]);
        } else if (rectangles[0].x1 == rectangles[1].x2 && rectangles[0].y1 != rectangles[1].y2 ||
                rectangles[0].x2 == rectangles[1].x1 && rectangles[0].y2 != rectangles[1].y1 ||
                rectangles[0].x1 != rectangles[1].x2 && rectangles[0].y2 == rectangles[1].y1 ||
                rectangles[0].x2 != rectangles[1].x1 && rectangles[0].y1 == rectangles[1].y2) {
            System.out.println(message[1]);
        } else {
            System.out.println(message[2]);
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }

    static class Rectangle {
        int x1;
        int y1;
        int x2;
        int y2;

        public Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
}
