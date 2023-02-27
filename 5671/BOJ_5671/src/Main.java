import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int N, M;
    private boolean[] isChecked;
    private String input;
    private int res;

    public boolean check(int i) {
        while (i > 0) {
            if (isChecked[i % 10]) return false;
            isChecked[i % 10] = true;
            i /= 10;
        }
        return true;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            res = 0;
            for (int i = N; i <= M; i++) {
                isChecked = new boolean[10];
                if (check(i)) {
                    res++;
                }
            }
            sb.append(res).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
