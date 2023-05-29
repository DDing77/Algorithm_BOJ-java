import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int res = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());

            res ^= (temp % 2 == 0) ? (temp - 1) / 2 : (temp + 1) / 2;
        }

        sb.append((res == 0) ? "cubelover" : "koosaga");
        System.out.println(sb);
    }
}
