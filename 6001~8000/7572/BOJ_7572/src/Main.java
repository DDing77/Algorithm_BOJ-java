import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int year;
    private int[] gan;
    private char[] zi;

    private void init() {

        gan = new int[10];
        for (int i = 0; i < gan.length; i++) {
            gan[i] = i;
        }

        zi = new char[12];
        for (int i = 0; i < zi.length; i++) {
            zi[i] = (char) (i + 65);
        }
    }

    private void solution() throws IOException {

        init();

        year = Integer.parseInt(br.readLine());

        sb.append(zi[(year + 8) % 12]).append(gan[(year + 6) % 10]);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
