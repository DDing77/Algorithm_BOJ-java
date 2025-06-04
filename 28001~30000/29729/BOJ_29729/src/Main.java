import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int size;
    private int N;
    private int M;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for (int i = 0; i < N + M; i++) {
            int op = Integer.parseInt(br.readLine());

            if (op == 0) {
                cnt--;
            } else {
                cnt++;
                if (size < cnt) {
                    size *= 2;
                }
            }
        }

        System.out.println(size);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
