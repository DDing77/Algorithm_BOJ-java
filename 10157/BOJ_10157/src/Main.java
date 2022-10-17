import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int C, R;
    static int K;
    static int[][] map;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        K = Integer.parseInt(br.readLine());
        int res = K;

        if (K > C * R) {
            System.out.println(0);
            return;
        }

        int x = 0;
        int y = 0;
        int direction = 0;
        int checkNumber = 1;
        while (K > 0) {
            if (direction % 4 == 0) {
                while (x < R && map[x][y] == 0 && K > 0) {
                    K--;
                    map[x++][y] = checkNumber++;
                }
                x--;
                y++;
                direction++;
            } else if (direction % 4 == 1) {
                while (y < C && map[x][y] == 0 && K > 0) {
                    K--;
                    map[x][y++] = checkNumber++;
                }
                y--;
                x--;
                direction++;
            } else if (direction % 4 == 2) {
                while (x > -1 && map[x][y] == 0 && K > 0) {
                    K--;
                    map[x--][y] = checkNumber++;
                }
                x++;
                y--;
                direction++;
            } else if (direction % 4 == 3) {
                while (map[x][y] == 0 && y > 0 && K > 0) {
                    K--;
                    map[x][y--] = checkNumber++;
                }
                y++;
                x++;
                direction++;
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == res) System.out.println(j + 1 + " " + (i + 1));
            }
        }
    }
}
