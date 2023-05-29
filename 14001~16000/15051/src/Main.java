import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A1 = Integer.parseInt(br.readLine());
        int A2 = Integer.parseInt(br.readLine());
        int A3 = Integer.parseInt(br.readLine());

        int res = Math.min(A2 * 2 + A3 * 4, Math.min(A1 * 2 + A3 * 2, A1 * 4 + A2 * 2));

        System.out.println(res);
    }
}