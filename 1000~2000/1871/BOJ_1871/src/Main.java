import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int T;
    String[] input;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input = br.readLine().split("-");

            int leftSum = 0;
            int right = Integer.parseInt(input[1]);

            for (int i = 0; i < 3; i++) {
                leftSum += Math.pow(26, (3 - i - 1)) * (input[0].charAt(i) - 'A');
            }

            if (Math.abs(leftSum - right) <= 100) {
                sb.append("nice");
            } else {
                sb.append("not nice");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
