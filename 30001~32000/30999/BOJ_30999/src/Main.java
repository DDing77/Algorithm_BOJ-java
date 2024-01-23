import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    int N;
    int M;
    int res;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        res = 0;
        for (int i = 0; i < N; i++) {
            String votes = br.readLine();
            int sum = 0;
            for (char vote : votes.toCharArray()) {
                if (vote == 'O') {
                    sum++;
                }

                if (sum > votes.length() / 2) {
                    res++;
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
