import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    int N;

    private String makeTop(int N) {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < N * 4; i++) {
            for (int j = 0; j < N; j++) {
                tmp.append("@");
            }
            tmp.append("\n");
        }
        return tmp.toString();
    }

    private String makeBottom(int N) {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N * 5; j++) {
                tmp.append("@");
            }
            tmp.append("\n");
        }
        return tmp.toString();
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());

        sb.append(makeTop(N));
        sb.append(makeBottom(N));

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
