import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private int T;
    private int N;
    private int[] persons;
    private boolean[] isVisited;
    private int K;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            if (N == 1) {
                System.out.println(1);
                return;
            }

            persons = new int[N + 1];
            isVisited = new boolean[N + 1];

            for (int i = 1; i <= N; i++) {
                persons[i] = Integer.parseInt(br.readLine());
            }

            K = 0;
            int cur = 1;
            while (cur != N && !isVisited[cur]) {
                K++;
                isVisited[cur] = true;
                cur = persons[cur];
            }

            if (cur != N) {
                sb.append("0");
            } else {
                sb.append(K);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
