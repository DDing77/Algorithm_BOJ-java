import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int N;
    int P;
    int res;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        res = P;

        if (N >= 20) {
            res = P - P / 4;
        }
        if (N >= 15) {
            res = Math.min(Math.max(0, P - 2000), res);
        }
        if (N >= 10) {
            res = Math.min(res, P - P / 10);
        }
        if (N >= 5) {
            res = Math.min(Math.max(0, P - 500), res);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
