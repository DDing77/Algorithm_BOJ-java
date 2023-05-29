import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, W, H, L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int row = W / L;
        int col = H / L;

        int cnt = row * col;

        if (N >= cnt) System.out.println(cnt);
        else System.out.println(N);
    }
}