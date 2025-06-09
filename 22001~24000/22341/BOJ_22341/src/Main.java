import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int C;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int curX = N;
        int curY = N;
        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            if (X >= curX || Y >= curY) {
                continue;
            }

            int hor = X * curY;
            int ver = Y * curX;

            if (hor > ver) {
                curX = X;
            } else if (hor < ver) {
                curY = Y;
            } else {
                curX = X;
            }
        }

        System.out.println(curX * curY);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
