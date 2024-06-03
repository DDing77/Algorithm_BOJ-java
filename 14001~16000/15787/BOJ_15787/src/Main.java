import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int[] trains;
    private Set<Integer> set;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trains = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            String op = st.nextToken();
            int idx = Integer.parseInt(st.nextToken());

            if (op.equals("1")) {
                int x = Integer.parseInt(st.nextToken());
                trains[idx] |= (1 << x);
            } else if (op.equals("2")) {
                int x = Integer.parseInt(st.nextToken());
                trains[idx] &= ~(1 << x);
            } else if (op.equals("3")) {
                trains[idx] <<= 1;
                trains[idx] &= ((1 << 21) - 1);
            } else if (op.equals("4")) {
                trains[idx] >>= 1;
                trains[idx] &= ~1;
            }
        }

        set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            set.add(trains[i]);
        }

        System.out.println(set.size());
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
