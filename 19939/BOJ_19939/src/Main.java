import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int N;
    private int K;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 1; N >= 0 && i <= K; i++) {
            N -= i;
        }

        if (N < 0) {
            System.out.println("-1");
        } else {
            if (N % K > 0) {
                System.out.println(K);
            } else {
                System.out.println(K - 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
