import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int X, Y, P1, P2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        P1 = Integer.parseInt(st.nextToken());
        P2 = Integer.parseInt(st.nextToken());
        int cnt = 0;
        while (cnt < 100) {
            if (P1 == P2) {
                System.out.println(P1);
                return;
            } else if (P1 > P2) P2 += Y;
            else P1 += X;
            cnt++;
        }
        System.out.println(-1);
    }
}
