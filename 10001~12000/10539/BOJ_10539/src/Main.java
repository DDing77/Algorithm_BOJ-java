import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int pre = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            sb.append(cur * i - pre * (i - 1)).append(" ");
            pre = cur;
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
