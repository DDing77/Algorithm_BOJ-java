import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private long res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());

        int startH = y1;
        if (y1 % 2 == 1) {
            startH++;
        } else {
            startH += 2;
        }

        for (int i = startH; i <= y2; i += 2) {
            if (i <= x1) {
                continue;
            }
            res += Math.min(i, x2) - x1;
        }

        int startV = x1;
        if (x1 % 2 == 1) {
            startV++;
        } else {
            startV += 2;
        }
        for (int i = startV; i <= x2; i += 2) {
            if (i <= y1) {
                continue;
            }
            res += Math.min(i - 1, y2) - y1;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
