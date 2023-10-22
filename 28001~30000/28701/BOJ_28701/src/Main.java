import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int N;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        int sum = N * (1 + N) / 2;

        int three = 0;
        for (int i = 1; i <= N; i++) {
            three += Math.pow(i, 3);
        }

        sb.append(sum).append('\n');
        sb.append(sum * sum).append('\n');
        sb.append(three);

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
