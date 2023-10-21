import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            res = 0;
            while (n > 0) {
                res += n--;
            }

            sb.append(res).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
