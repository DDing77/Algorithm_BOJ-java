import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int A;
    private int B;
    private int C;
    private int res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int day = 1;
        int count = 0;
        while (true) {
            count = day * A;
            if (B != 0) {
                count += (day / 7) * B;
            }
            if (count >= C) {
                break;
            }
            day++;
        }

        System.out.println(day);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
