import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int A;
    int B;
    int C;
    int M;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int time = 24;
        int tired = 0;
        res = 0;
        while (time-- > 0) {
            if (A > M) {
                break;
            }
            if (A + tired > M) {
                tired -= C;
                if (tired < 0) {
                    tired = 0;
                }
            } else {
                tired += A;
                res += B;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
