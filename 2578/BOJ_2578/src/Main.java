import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int res;
    static int cnt;

    static void isHorizon() {
        for (int i = 1; i <= 5; i++) {
            int zero = 0;
            for (int j = 1; j <= 5; j++) {
                if (map[i][j] == 0) zero++;
            }
            if (zero == 5) cnt++;
        }
    }

    static void isVertical() {
        for (int i = 1; i <= 5; i++) {
            int zero = 0;
            for (int j = 1; j <= 5; j++) {
                if (map[j][i] == 0) zero++;
            }
            if (zero == 5) cnt++;
        }
    }

    static void isLr() {
        int zero = 0;
        for (int i = 1; i <= 5; i++) {
            if (map[i][i] == 0) zero++;
        }
        if (zero == 5) cnt++;
    }

    static void isRl() {
        int zero = 0;
        for (int i = 1; i <= 5; i++) {
            if (map[i][6 - i] == 0) zero++;
        }
        if (zero == 5) cnt++;
    }

    static void findLocation(int num) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                if (map[i][j] == num) {
                    map[i][j] = 0;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[6][6];

        for (int i = 1; i <= 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        res = 0;
        cnt = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int cur = Integer.parseInt(st.nextToken());
                res++;

                findLocation(cur);

                isHorizon();
                isVertical();
                isLr();
                isRl();

                if (cnt >= 3) {
                    System.out.println(res);
                    return;
                }
                cnt = 0;
            }
        }
    }
}
