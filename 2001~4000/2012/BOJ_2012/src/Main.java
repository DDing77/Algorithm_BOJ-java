import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    int N;
    int[] ranks;
    long res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ranks = new int[N];

        for (int i = 0; i < N; i++) {
            ranks[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ranks);

        res = 0L;
        for (int i = 0; i < N; i++) {
            res += Math.abs((i + 1) - ranks[i]);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
