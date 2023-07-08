import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int N;
    static String input;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            input = st.nextToken();

            for (int i = 0; i < input.length(); i++) {
                if (i == N - 1) {
                    continue;
                }
                sb.append(input.charAt(i));
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
