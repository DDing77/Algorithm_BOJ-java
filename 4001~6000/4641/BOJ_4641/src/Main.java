import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    boolean[] numbers;
    int res;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            String input = br.readLine();
            if (input.equals("-1")) {
                break;
            }

            numbers = new boolean[201];

            st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                numbers[Integer.parseInt(st.nextToken())] = true;
            }

            res = 0;
            st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                int cur = Integer.parseInt(st.nextToken());
                if (cur == 0) {
                    break;
                }
                if (numbers[cur * 2]) {
                    res++;
                }
            }
            sb.append(res).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
