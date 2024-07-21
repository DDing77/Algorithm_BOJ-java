import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private char[][] originBoard;
    private char[][] resBoard;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        originBoard = new char[N][M];
        for (int i = 0; i < N; i++) {
            originBoard[i] = br.readLine().toCharArray();
        }

        resBoard = new char[M][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char ch = originBoard[i][j];
                if (ch == '.') {
                    resBoard[M - 1 - j][i] = '.';
                } else if (ch == 'O') {
                    resBoard[M - 1 - j][i] = 'O';
                } else if (ch == '-') {
                    resBoard[M - 1 - j][i] = '|';
                } else if (ch == '|') {
                    resBoard[M - 1 - j][i] = '-';
                } else if (ch == '/') {
                    resBoard[M - 1 - j][i] = '\\';
                } else if (ch == '\\') {
                    resBoard[M - 1 - j][i] = '/';
                } else if (ch == '^') {
                    resBoard[M - 1 - j][i] = '<';
                } else if (ch == '<') {
                    resBoard[M - 1 - j][i] = 'v';
                } else if (ch == 'v') {
                    resBoard[M - 1 - j][i] = '>';
                } else if (ch == '>') {
                    resBoard[M - 1 - j][i] = '^';
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(resBoard[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
