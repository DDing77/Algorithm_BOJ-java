import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private int T;
    private char[][] map;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String encrypted = br.readLine();
            int length = (int) Math.sqrt(encrypted.length());

            map = new char[length][length];

            int cnt = 0;
            for (int i = 0; i < length; i++) {
                map[i] = encrypted.substring(cnt, cnt + length).toCharArray();
                cnt += length;
            }

            for (int j = length - 1; j >= 0; j--) {
                for (int i = 0; i < length; i++) {
                    sb.append(map[i][j]);
                }
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
