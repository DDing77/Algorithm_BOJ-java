import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int C;
    private int number;
    private int res;

    private void solution() throws IOException {

        C = Integer.parseInt(br.readLine());
        while (C-- > 0) {
            number = Integer.parseInt(br.readLine());
            res = 0;
            for (int i = 1; i <= Math.sqrt(number); i++) {
                if (i * i == number) {
                    res++;
                } else if (number % i == 0) {
                    res += 2;
                }
            }

            sb.append(number).append(" ").append(res).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
