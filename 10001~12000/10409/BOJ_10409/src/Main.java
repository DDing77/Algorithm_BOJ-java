import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int t;
    static int res;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        int sum = 0;
        res = 0;
        int cur;
        st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            cur = Integer.parseInt(st.nextToken());
            if (sum + cur > t) {
                break;
            }

            sum += cur;
            res++;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
