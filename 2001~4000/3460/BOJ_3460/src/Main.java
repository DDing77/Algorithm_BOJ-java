import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            String res = "";
            while (N > 0) {
                res += N % 2;
                N /= 2;
            }
            for (int i = 0; i < res.length(); i++) {
                if (res.charAt(i) == '1') sb.append(i + " ");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
