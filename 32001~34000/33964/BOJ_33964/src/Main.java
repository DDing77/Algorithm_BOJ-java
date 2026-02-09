import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int X;
    private int Y;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        int resX = 0;
        for (int i = 0; i < X; i++) {
            resX *= 10;
            resX += 1;
        }

        int resY = 0;
        for (int i = 0; i < Y; i++) {
            resY *= 10;
            resY += 1;
        }

        System.out.println(resX + resY);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
