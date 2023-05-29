import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static StringBuilder res;
    static StringBuilder input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        res = new StringBuilder();
        for (int i = 0; i < N; i++) {
            input = new StringBuilder();
            String cur = br.readLine();
            input.append(cur);
            input.reverse();
            res.append(input).append('\n');
        }
        System.out.println(res);
    }
}
