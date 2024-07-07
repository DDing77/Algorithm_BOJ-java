import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private String[] names;
    private String[][] messages;
    private int groupNumber;

    private void solution() throws IOException {

        groupNumber = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            names = new String[N];
            messages = new String[N][N - 1];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                names[i] = st.nextToken();
                for (int j = 0; j < N - 1; j++) {
                    messages[i][j] = st.nextToken();
                }
            }

            sb.append("Group ").append(groupNumber++).append("\n");

            boolean isAllPositive = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N - 1; j++) {
                    if (messages[i][j].equals("N")) {
                        isAllPositive = false;
                        int reqIdx = i - j - 1;
                        if (reqIdx < 0) {
                            reqIdx = N + reqIdx;
                        }
                        sb.append(names[reqIdx]).append(" was nasty about ").append(names[i]).append("\n");
                    }
                }
            }

            if (isAllPositive) {
                sb.append("Nobody was nasty").append("\n");
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
