import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] S1;
    private int[] S2;
    private int[] pi;

    private void setPi() {
        pi = new int[S2.length];

        int j = 0;
        int length = pi.length;
        for (int i = 1; i < length; i++) {
            while (j > 0 && S2[j] != S2[i]) {
                j = pi[j - 1];
            }

            if (S2[j] == S2[i]) {
                pi[i] = ++j;
            }
        }
    }

    private boolean kmp() {
        int length1 = S1.length;
        int length2 = S2.length;

        int j = 0;
        for (int i = 0; i < length1; i++) {
            while (j > 0 && S1[i] != S2[j]) {
                j = pi[j - 1];
            }
            if (S1[i] == S2[j]) {
                if (j == length2 - 1) {
                    return true;
                }
                j++;
            }
        }
        return false;
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());

        S1 = new int[N * 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S1[i] = Integer.parseInt(st.nextToken());
            S1[i + N] = S1[i];
        }

        S2 = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S2[i] = Integer.parseInt(st.nextToken());
        }

        setPi();

        if (kmp()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
