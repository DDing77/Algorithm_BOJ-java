import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int speed;
    private int time;
    private int res;

    private void solution() throws IOException {

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == -1) {
                break;
            }

            int preTime = 0;
            res = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                speed = Integer.parseInt(st.nextToken());
                time = Integer.parseInt(st.nextToken());

                res += speed * (time - preTime);
                preTime = time;
            }

            sb.append(res).append(" miles").append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
