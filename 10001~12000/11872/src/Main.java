import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int res = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());

            if (temp % 4 == 0) {
                temp--;
            } else if (temp % 4 == 3) {
                temp++;
            }

            res ^= temp;
        }

        if (res == 0) System.out.println("cubelover");
        else System.out.println("koosaga");
    }
}
