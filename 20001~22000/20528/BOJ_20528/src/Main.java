import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private String[] S;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        S = new String[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = st.nextToken();
        }

        for (int i = 1; i < N; i++) {
            if ((S[i].charAt(0) != S[i].charAt(S[i].length() - 1)) || S[i - 1].charAt(S[i - 1].length() - 1) != S[i].charAt(0)) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
