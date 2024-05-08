import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int P;
    private int Q;
    private ArrayList<Integer> pDivisor;
    private ArrayList<Integer> qDivisor;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        pDivisor = new ArrayList<>();
        for (int i = 1; i <= P; i++) {
            if (P % i == 0) {
                pDivisor.add(i);
            }
        }

        qDivisor = new ArrayList<>();
        for (int i = 1; i <= Q; i++) {
            if (Q % i == 0) {
                qDivisor.add(i);
            }
        }

        for (int p : pDivisor) {
            for (int q : qDivisor) {
                sb.append(p).append(" ").append(q).append("\n");
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
