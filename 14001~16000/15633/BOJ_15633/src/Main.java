import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int n;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        res = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                res += i;
            }
        }
        System.out.println(res * 5 - 24);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
