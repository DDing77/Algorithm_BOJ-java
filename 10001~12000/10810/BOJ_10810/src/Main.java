import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int N, M;
    private int[] containers;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        containers = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            for (int idx = left; idx <= right; idx++) {
                containers[idx] = number;
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(containers[i] + " ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
