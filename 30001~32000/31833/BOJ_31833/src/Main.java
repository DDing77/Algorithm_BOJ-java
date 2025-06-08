import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;

    private String getString() throws IOException {
        StringBuilder S = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S.append(st.nextToken());
        }

        return S.toString();
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());

        long S1 = Long.parseLong(getString());
        long S2 = Long.parseLong(getString());

        System.out.println(Math.min(S1, S2));
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
