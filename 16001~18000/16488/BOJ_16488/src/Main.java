import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long N;
    static int K;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        long res = N * N * K;

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
