import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    int N;

    private void generateType1() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append("@");
            }
            for (int j = 0; j < N * 3; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < N; j++) {
                sb.append("@");
            }
            sb.append("\n");
        }
    }

    private void generateType2() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N * 5; j++) {
                sb.append("@");
            }
            sb.append("\n");
        }
    }


    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        generateType1();
        generateType2();
        generateType1();
        generateType2();
        generateType1();

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
