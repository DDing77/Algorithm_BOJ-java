import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private String S;

    private boolean isConsonant(char c) {
        return c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U';
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        S = br.readLine();

        int consonantIndex = -1;
        for (int i = N - 1; i >= 0; i--) {
            if (isConsonant(S.charAt(i))) {
                consonantIndex = i;
                break;
            }
        }

        if (consonantIndex == -1) {
            System.out.println("NO");
            return;
        }

        int secondAIndex = -1;
        for (int i = consonantIndex - 1; i >= 0; i--) {
            if (S.charAt(i) == 'A') {
                secondAIndex = i;
                break;
            }
        }

        if (secondAIndex == -1) {
            System.out.println("NO");
            return;
        }

        int firstAIndex = -1;
        for (int i = secondAIndex - 1; i >= 0; i--) {
            if (S.charAt(i) == 'A') {
                firstAIndex = i;
                break;
            }
        }

        if (firstAIndex == -1) {
            System.out.println("NO");
            return;
        }

        if (firstAIndex < M - 3) {
            System.out.println("NO");
            return;
        }

        sb.append("YES\n");

        for (int i = 0; i < M - 3; i++) {
            sb.append(S.charAt(i));
        }
        sb.append('A');
        sb.append('A');
        sb.append(S.charAt(consonantIndex));

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}