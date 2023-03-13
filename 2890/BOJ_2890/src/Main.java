import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int R, C;
    private char[][] map;
    private int[] rank;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        rank = new int[R];
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }


        int rankIdx = 1;
        for (int i = C - 2; i > 0; i--) {
            boolean isUp = false;
            for (int j = 0; j < R; j++) {
                if (map[j][i] != '.') {
                    if (rank[map[j][i] - '0'] == 0) {
                        rank[map[j][i] - '0'] = rankIdx;
                        isUp = true;
                    }
                }
            }
            if (isUp) {
                rankIdx++;
            }
        }

        for (int i = 0; i < R; i++) {
            if (rank[i] != 0) {
                sb.append(rank[i]).append('\n');
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
