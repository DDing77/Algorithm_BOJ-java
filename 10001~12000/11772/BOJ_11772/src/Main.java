import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    int N;
    long res;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        res = 0;

        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());
            res += Math.pow(cur / 10, cur % 10);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
