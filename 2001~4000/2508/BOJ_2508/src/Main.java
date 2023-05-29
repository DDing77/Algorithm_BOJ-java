import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int t;
    private int r;
    private int c;
    private char[][] map;
    private int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            br.readLine();
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            map = new char[r][c];

            for (int i = 0; i < r; i++) {
                map[i] = br.readLine().toCharArray();
            }

            res = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j <= c - 3; j++) {
                    if (map[i][j] == '>' && map[i][j + 1] == 'o' && map[i][j + 2] == '<') {
                        res++;
                    }
                }
            }

            for (int i = 0; i < c; i++) {
                for (int j = 0; j <= r - 3; j++) {
                    if (map[j][i] == 'v' && map[j + 1][i] == 'o' && map[j + 2][i] == '^') {
                        res++;
                    }
                }
            }

            sb.append(res).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}