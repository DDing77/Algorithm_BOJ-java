import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] number;
    static String[] name;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            number = new int[N + 1];
            name = new String[N + 1];

            for (int i = 1; i <= N; i++) name[i] = br.readLine();
            for (int i = 0; i < 2 * N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                number[Integer.parseInt(st.nextToken())]++;
            }

            for (int i = 1; i <= N; i++) {
                if (number[i] % 2 != 0) sb.append(tc + " ").append(name[i]).append('\n');
            }
            tc++;
        }

        System.out.print(sb);
    }
}
