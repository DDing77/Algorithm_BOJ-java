import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static boolean[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static void curve(int x, int y, int d, int g) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(d);

        while (g-- > 0) {
            for (int i = list.size() - 1; i >= 0; i--) {
                list.add((list.get(i) + 1) % 4);
            }
        }

        map[x][y] = true;

        for (int dir : list) {
            x += dx[dir];
            y += dy[dir];
            map[x][y] = true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new boolean[101][101];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            curve(x, y, d, g);
        }

        int res = 0;
        for(int i=0; i<100; i++) {
            for(int j=0; j<100; j++) {
                if( map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) res++;
            }
        }

        System.out.println(res);
    }
}