import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int minValue;
    private int res;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        minValue = Integer.MAX_VALUE;
        res = 0;
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (value < minValue) {
                res = i;
                minValue = value;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
