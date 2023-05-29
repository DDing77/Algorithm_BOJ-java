import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n1, k1, n2, k2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n1 = Integer.parseInt(st.nextToken());
        k1 = Integer.parseInt(st.nextToken());
        n2 = Integer.parseInt(st.nextToken());
        k2 = Integer.parseInt(st.nextToken());

        System.out.println(n1*k1 + n2 * k2);
    }
}
