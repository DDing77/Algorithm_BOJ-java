import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R1, S;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R1 = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        res = 2 * S - R1;

        System.out.println(res);
    }
}
