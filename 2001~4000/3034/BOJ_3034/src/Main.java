import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, W, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int slop = W * W + H * H;

        for (int i = 0; i < N; i++) {
            int match = Integer.parseInt(br.readLine());
            if (match <= W || match <= H || match * match <= slop) {
                sb.append("DA").append('\n');
                continue;
            }
            sb.append("NE").append('\n');
        }
        System.out.println(sb);
    }
}
