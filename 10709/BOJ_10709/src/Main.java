import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int H, W;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        for (int i = 0; i < H; i++) map[i] = br.readLine().toCharArray();

        for (int i = 0; i < H; i++) {
            int preC = -1;
            for (int j = 0; j < W; j++) {
                char cur = map[i][j];
                if (cur == 'c') {
                    preC = j;
                    sb.append(0).append(" ");
                } else {
                    if (preC == -1) sb.append(-1).append(" ");
                    else sb.append(j - preC).append(" ");
                }
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
