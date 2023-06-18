import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int W;
    static int H;
    static int startX;
    static int endX;
    static int startY;
    static int endY;
    static int P;
    static int r;
    static int res;

    public static double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        endX = startX + W;
        endY = startY + H;
        r = H / 2;
        int halfY = startY + r;

        int playerX;
        int playerY;
        res = 0;
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            playerX = Integer.parseInt(st.nextToken());
            playerY = Integer.parseInt(st.nextToken());

            if ((startX <= playerX && playerX <= endX && startY <= playerY && playerY <= endY)
                    || getDistance(playerX, playerY, startX, halfY) <= r || getDistance(playerX, playerY, endX, halfY) <= r
            ) {
                res++;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
