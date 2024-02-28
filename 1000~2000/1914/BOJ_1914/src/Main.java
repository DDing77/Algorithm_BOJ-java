import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    int N;

    private void execHanoi(int N, int from, int to, int via) {
        System.out.println("from = " + from);
        System.out.println("to = " + to);
        System.out.println("via = " + via);
        if (N == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        execHanoi(N - 1, from, via, to);
        sb.append(from).append(" ").append(to).append("\n");
        execHanoi(N - 1, via, to, from);
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        sb.append(BigInteger.TWO.pow(N).subtract(BigInteger.ONE)).append("\n");

        if (N <= 20) {
            execHanoi(N, 1, 3, 2);
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
