import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    int[] subject;
    int T;
    int res;

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            subject[i] = Integer.parseInt(st.nextToken());
        }

        res = Math.abs(subject[0] - subject[2]);
        if (subject[0] > subject[2]) {
            res *= 508;
        } else {
            res *= 108;
        }

        int diff = Math.abs(subject[1] - subject[3]);
        if (subject[1] > subject[3]) {
            diff *= 212;
        } else {
            diff *= 305;
        }
        res += diff;

        if (subject[4] != 0) {
            res += subject[4] * 707;
        }

        res *= 4763;

        sb.append(res);
        System.out.println(sb);
    }

    private void init() {
        subject = new int[5];
        Arrays.fill(subject, 0);
        res = 0;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.init();
        main.solution();
    }
}
