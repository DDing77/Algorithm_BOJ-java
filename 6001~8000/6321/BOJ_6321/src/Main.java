import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static String input;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            sb.append("String #" + i + '\n');
            input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                int cur = input.charAt(j) + 1;

                if (cur > 'Z') {
                    cur = 'A';
                }

                sb.append((char) cur);
            }
            sb.append("\n\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
