import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final String[] dice1 = {"", "Yakk", "Doh", "Seh", "Ghar", "Bang", "Sheesh"};
    private static final String[] dice2 = {"", "Habb Yakk", "Dobara", "Dousa", "Dorgy", "Dabash", "Dosh"};
    private int N;
    private int a;
    private int b;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            int small = Math.min(a, b);
            int big = Math.max(a, b);

            sb.append("Case ").append(i + 1).append(": ");
            if (small == big) {
                sb.append(dice2[small]).append("\n");
            } else if (small == 5 && big == 6) {
                sb.append("Sheesh Beesh").append("\n");
            } else {
                sb.append(dice1[big]).append(" ").append(dice1[small]).append("\n");
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
