import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private char[][] sentences;

    private void solution() throws IOException {
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            sentences = new char[N][100];
            for (int i = 0; i < N; i++) {
                sentences[i] = br.readLine().toCharArray();
            }

            int curRow = 0;
            int curCol = 0;
            while (curRow < N) {
                while (curCol < sentences[curRow].length && sentences[curRow][curCol] != ' ') {
                    curCol++;
                }
                curRow++;
            }
            sb.append(curCol + 1).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
