import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private char[][] map;
    private Set<String> res;
    private StringBuilder sb;

    public void execDFS(int x, int y, int depth) {
        if (depth > 6) {
            res.add(sb.toString());
            return;
        }

        for (int k = 0; k < 4; k++) {
            int nX = x + dir[k][0];
            int nY = y + dir[k][1];

            if (nX < 0 || nX >= 5 || nY < 0 || nY >= 5) {
                continue;
            }

            sb.append(map[nX][nY]);
            execDFS(nX, nY, depth + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        map = new char[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        res = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                sb = new StringBuilder();
                execDFS(i, j, 1);
            }
        }

        System.out.println(res.size());
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
