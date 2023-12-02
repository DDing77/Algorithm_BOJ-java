import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int N;
    int M;
    String[] pattern;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pattern = new String[N];
        for (int i = 0; i < N; i++) {
            pattern[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            if (input.length() != M * 2) {
                System.out.println("Not Eyfa");
                return;
            }

            for (int j = 0; j < M; j++) {
                if (pattern[i].charAt(j) != input.charAt(j * 2) || pattern[i].charAt(j) != input.charAt(j * 2 + 1)) {
                    System.out.println("Not Eyfa");
                    return;
                }
            }
        }

        System.out.println("Eyfa");
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
