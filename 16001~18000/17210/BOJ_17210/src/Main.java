import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    long N;
    int type;

    private void solution() throws IOException {

        N = Long.parseLong(br.readLine());
        type = Integer.parseInt(br.readLine());

        if (N >= 6) {
            System.out.println("Love is open door");
            return;
        }

        for (int i = 1; i < N; i++) {
            type ^= 1;
            sb.append(type).append("\n");
        }

        System.out.print(sb);
        // 1 2 3 4 5 6 7 8 9 10
        // 0 1 0 1 0 1 0 1 0 1
        // 1 0 1 0 1 0 1 0 1 0
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
