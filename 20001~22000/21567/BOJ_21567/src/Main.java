import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private long res;
    private int[] cntArr = new int[10];

    private void solution() throws IOException {
        res = 1L;

        for (int i = 0; i < 3; i++) {
            res *= Integer.parseInt(br.readLine());
        }

        while (res > 0) {
            long value = res % 10;
            cntArr[(int) value]++;
            res /= 10;
        }

        for (int i = 0; i < 10; i++) {
            sb.append(cntArr[i]).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
