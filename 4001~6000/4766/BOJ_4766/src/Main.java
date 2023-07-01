import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        double pre = Double.parseDouble(br.readLine());
        while (true) {
            double cur = Double.parseDouble(br.readLine());

            if (cur == 999) {
                break;
            }

            sb.append(String.format("%.2f", cur - pre)).append('\n');

            pre = cur;
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
