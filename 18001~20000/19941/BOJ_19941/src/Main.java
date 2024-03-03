import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int K;
    char[] table;
    int res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        table = br.readLine().toCharArray();

        res = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i] == 'H' || table[i] == 'x') {
                continue;
            }

            for (int j = Math.max(0, i - K); j <= Math.min(N - 1, i + K); j++) {
                if (table[j] == 'H') {
                    res++;
                    table[j] = 'x';
                    break;
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
