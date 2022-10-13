import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] alpha;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String str = br.readLine();
            char c[] = str.toCharArray();
            alpha = new int[26];

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < c.length; i++) {
                sb.append(c[i]);
                if (++alpha[c[i] - 65] == 3) {
                    sb.append(c[i]);
                    alpha[c[i] - 65] = 0;
                    i++;
                }
            }
            System.out.println(str.equals(sb.toString()) == true ? "OK" : "FAKE");
        }
    }
}
