import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private ArrayDeque<String>[] parrots;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        parrots = new ArrayDeque[N];

        for (int i = 0; i < N; i++) {
            parrots[i] = new ArrayDeque<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                parrots[i].add(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        boolean result = true;
        while (st.hasMoreTokens()) {
            String curWord = st.nextToken();
            boolean found = false;
            for (int i = 0; i < N; i++) {
                if (!parrots[i].isEmpty() && parrots[i].peek().equals(curWord)) {
                    parrots[i].poll();
                    found = true;
                    break;
                }
            }

            if (!found) {
                result = false;
                break;
            }
        }

        for (int i = 0; i < N; i++) {
            if (!parrots[i].isEmpty()) {
                result = false;
                break;
            }
        }

        if (result) {
            System.out.println("Possible");
        } else {
            System.out.println("Impossible");
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
