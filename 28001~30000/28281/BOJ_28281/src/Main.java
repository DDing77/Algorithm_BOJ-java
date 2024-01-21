import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    int N;
    int X;
    int yesterday;
    int beforeYesterday;
    int res;
    int sum;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        beforeYesterday = Integer.parseInt(st.nextToken());
        yesterday = Integer.parseInt(st.nextToken());

        res = beforeYesterday * X + yesterday * X;
        sum = res;
        for (int i = 2; i < N; i++) {
            sum -= beforeYesterday * X;
            beforeYesterday = yesterday;
            yesterday = Integer.parseInt(st.nextToken());
            sum += yesterday * X;
            res = Math.min(res, sum);
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
