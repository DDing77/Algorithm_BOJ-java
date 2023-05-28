import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int next;
    static int res;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        res = 0;
        next = 0;

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            if (Integer.parseInt(st.nextToken()) == next) {
                res++;
                next = (next + 1) % 3;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
