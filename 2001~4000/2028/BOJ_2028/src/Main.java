import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String inputStr = br.readLine();
            int inputNum = Integer.parseInt(inputStr);
            int pow = inputNum * inputNum;
            String powStr = String.valueOf(pow);

            if (inputStr.equals(powStr.substring(powStr.length() - inputStr.length()))) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
