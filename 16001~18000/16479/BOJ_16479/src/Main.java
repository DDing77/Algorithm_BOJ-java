import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int K;
    static int D1, D2;
    static double res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        D1 = Integer.parseInt(st.nextToken());
        D2 = Integer.parseInt(st.nextToken());

        double temp = (Math.abs(D1 - D2)) / 2.0;

        res = K * K - temp * temp;

        System.out.println(res);
    }
}
