import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int L;
    int R;
    int A;
    int res;

    private void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        res = L + R;
    }

    private void solution() {
        int diff = Math.abs(L - R);
        if (diff <= A) {
            res += diff;
            A -= diff;
        } else {
            res += A;
            res -= diff - A;
            A = 0;
        }

        res += A / 2;
        res += A / 2;

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.init();
        main.solution();
    }
}
