import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int SIZE = 3;

    private int[] cups;
    private int[] milks;

    private void solution() throws IOException {
        cups = new int[SIZE];
        milks = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            cups[i] = Integer.parseInt(st.nextToken());
            milks[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 100; i++) {
            int x = i % 3;
            int nx = (i + 1) % 3;

            int pourAmount = Math.min(milks[x],cups[nx] - milks[nx]);
            milks[x] -= pourAmount;
            milks[nx] += pourAmount;
        }

        for (int value : milks) {
            sb.append(value).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
