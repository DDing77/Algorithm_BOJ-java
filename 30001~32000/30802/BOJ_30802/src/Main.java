import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] orders;
    private int T;
    private int P;
    private int shirtRes;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        orders = new int[6];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < orders.length; i++) {
            orders[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        for (int order : orders) {
            shirtRes += (order + (T - 1)) / T;
        }

        sb.append(shirtRes).append("\n")
                .append(N / P).append(" ").append(N % P);

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
