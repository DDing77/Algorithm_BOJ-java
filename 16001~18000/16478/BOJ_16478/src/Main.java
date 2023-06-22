import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int ab;
    static int bc;
    static int cd;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ab = Integer.parseInt(st.nextToken());
        bc = Integer.parseInt(st.nextToken());
        cd = Integer.parseInt(st.nextToken());

        double res = ab * cd / (double) bc;

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
