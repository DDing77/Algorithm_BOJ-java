import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int D, H, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        D = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int preSum = 11 + 11 * 60 + 11 * 60 * 24;
        int ans = M + H * 60 + D * 60 * 24 - preSum;

        if (ans < 0) System.out.println(-1);
        else System.out.println(ans);
    }
}
