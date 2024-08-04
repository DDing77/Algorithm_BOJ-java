import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int res;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        int num = 1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int curInput = Integer.parseInt(st.nextToken());
            if (num == curInput) {
                num++;
            } else {
                res++;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
