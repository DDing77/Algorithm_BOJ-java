import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();


    private int T;
    private int[] fibo;
    private int N;
    private ArrayList<Integer> answer;

    private void initFibo() {

        fibo = new int[45];
        fibo[0] = 1;
        fibo[1] = 1;

        for (int i = 2; i < fibo.length; i++) {
            fibo[i] = fibo[i - 2] + fibo[i - 1];
        }
    }

    private void solution() throws IOException {

        initFibo();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            answer = new ArrayList<>();

            for (int i = fibo.length - 1; i >= 0; i--) {
                if (N >= fibo[i]) {
                    answer.add(fibo[i]);
                    N -= fibo[i];
                }
                if (N == 0) {
                    break;
                }
            }

            Collections.sort(answer);
            for (int value : answer) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
