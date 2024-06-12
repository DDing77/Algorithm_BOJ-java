import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private long N;
    private int P;
    private int Q;
    private HashMap<Long, Long> dp;

    private long find(long number) {

        if (dp.containsKey(number)) {
            return dp.get(number);
        }

        long left = (number / P);
        long right = (number / Q);
        dp.put(number, find(left) + find(right));

        return dp.get(number);
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        dp = new HashMap<>();
        dp.put(0L, 1L);

        System.out.println(find(N));
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
