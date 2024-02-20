import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int x;
    int y;
    int startX;
    int startY;
    int res;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());

        res = 0;
        x = startX;
        y = startY;

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int curX = Integer.parseInt(st.nextToken());
            int curY = Integer.parseInt(st.nextToken());
            res += Math.abs(curX - x + curY - y);
            x = curX;
            y = curY;
        }

        res += Math.abs(startX - x + startY - y);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
