import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private ArrayList<Integer>[] dots;
    private long res;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        dots = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            dots[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            dots[y].add(x);
        }

        res = 0L;
        for (int i = 1; i <= N; i++) {
            if (dots[i].size() <= 1) {
                continue;
            }
            Collections.sort(dots[i]);
            int length = dots[i].size();
            for (int j = 0; j < length; j++) {
                if (j == 0) {
                    res += dots[i].get(j + 1) - dots[i].get(j);
                } else if (j == length - 1) {
                    res += dots[i].get(j) - dots[i].get(j - 1);
                } else {
                    res += Math.min(dots[i].get(j) - dots[i].get(j - 1), dots[i].get(j + 1) - dots[i].get(j));
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
