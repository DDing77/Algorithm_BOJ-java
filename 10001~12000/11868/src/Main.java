import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        p = new int[N];

        st = new StringTokenizer(br.readLine());
        int res = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
            res ^= p[i];
        }

        if (res == 0) System.out.println("cubelover");
        else System.out.println("koosaga");

    }
}
