import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private String input;
    private char[][] res;

    public void change() {
        for (int i = 10; i < input.length() * 4; i += 12) {
            res[2][i - 2] = '*';
            res[1][i - 1] = '*';
            res[0][i] = '*';
            res[1][i + 1] = '*';
            res[2][i + 2] = '*';
            res[3][i + 1] = '*';
            res[4][i] = '*';
            res[3][i - 1] = '*';
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        input = br.readLine();
        int length = 4 * input.length() + 1;
        res = new char[5][length];

        int idx = 0;

        res[0][0] = '.';
        res[1][0] = '.';
        res[2][0] = '#';
        res[3][0] = '.';
        res[4][0] = '.';
        for (int i = 1; i < length - 1; i += 4) {
            res[0][i] = '.';
            res[0][i + 1] = '#';
            res[0][i + 2] = '.';
            res[0][i + 3] = '.';

            res[1][i] = '#';
            res[1][i + 1] = '.';
            res[1][i + 2] = '#';
            res[1][i + 3] = '.';

            res[2][i] = '.';
            res[2][i + 1] = input.charAt(idx++);
            res[2][i + 2] = '.';
            res[2][i + 3] = '#';

            res[3][i] = '#';
            res[3][i + 1] = '.';
            res[3][i + 2] = '#';
            res[3][i + 3] = '.';

            res[4][i] = '.';
            res[4][i + 1] = '#';
            res[4][i + 2] = '.';
            res[4][i + 3] = '.';
        }


        change();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < length; j++) {
                sb.append(res[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
