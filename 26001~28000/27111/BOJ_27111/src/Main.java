import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private HashSet<Integer> set = new HashSet<>();
    private int res;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (b == 0) {
                if (!set.contains(a)) {
                    res++;
                } else {
                    set.remove(a);
                }
            } else {
                if (set.contains(a)) {
                    res++;
                } else {
                    set.add(a);
                }
            }
        }

        res += set.size();
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
