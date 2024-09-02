import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private boolean[] paper;
    private ArrayList<Integer> lost;
    private int res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            paper[Integer.parseInt(st.nextToken())] = true;
        }

        lost = new ArrayList();
        for (int i = 1; i < paper.length; i++) {
            if (!paper[i]) {
                lost.add(i);
            }
        }

        for (int i = 0; i < lost.size(); i++) {
            if (i == 0) {
                res += 7;
            } else {
                res += Math.min(7, (lost.get(i) - lost.get(i - 1)) * 2);
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
