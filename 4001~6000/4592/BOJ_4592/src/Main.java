import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            if (N == 0) {
                break;
            }

            int pre = -1;
            int cur;

            for (int i = 0; i < N; i++) {
                cur = Integer.parseInt(st.nextToken());
                if (cur != pre) {
                    sb.append(cur + " ");
                    pre = cur;
                }
            }
            sb.append("$").append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
