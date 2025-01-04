import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private char[][] types;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        types = new char[2][M];

        for (int i = 0; i < M; i++) {
            if (i % 2 == 0) {
                types[0][i] = '*';
            } else {
                types[0][i] = '.';
            }
        }

        for (int i = 0; i < M; i++) {
            if (types[0][i] == '*') {
                types[1][i] = '.';
            } else {
                types[1][i] = '*';
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(types[i % 2]).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
