import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int[][] map;
    private int max, row, col;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        max = -1;
        row = 0;
        col = 0;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if (cur > max) {
                    max = cur;
                    row = i + 1;
                    col = j + 1;
                }
            }
        }

        sb.append(max).append('\n');
        sb.append(row + " " + col);

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
