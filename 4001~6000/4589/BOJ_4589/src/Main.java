import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int T;
    int[] numbers;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        sb.append("Gnomes:").append("\n");

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            numbers = new int[3];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            if ((numbers[0] <= numbers[1] && numbers[1] <= numbers[2]) || (numbers[0] >= numbers[1] && numbers[1] >= numbers[2])) {
                sb.append("Ordered");
            } else {
                sb.append("Unordered");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
