import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static String input;
    static int cnt;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        input = br.readLine();

        cnt = 1;
        for (int i = 0; i < N; i++) {
            char cur = input.charAt(i);
            cnt++;
            if (cur != 'S') {
                i++;
            }
        }

        System.out.println(Math.min(cnt, N));
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
