import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int N, M, K;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (M + N - 1 > K) {
            System.out.println("NO");
            return;
        }

        sb.append("YES").append('\n');
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(i + j + 1 + " ");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}

// 1 2 3 4 5
// 2 3 4 5 6
// 3 4 5 6 7