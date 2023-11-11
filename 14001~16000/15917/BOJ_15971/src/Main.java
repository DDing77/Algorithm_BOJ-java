import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int Q;
    int a;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {
            a = Integer.parseInt(br.readLine());

            if ((a & (a - 1)) > 0) {
                sb.append("0");
            } else {
                sb.append("1");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
