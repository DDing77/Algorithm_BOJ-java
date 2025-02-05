import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private long N;
    private Set<Character> set;
    private int K;

    private void solution() throws IOException {

        String input;
        while ((input = br.readLine()) != null) {
            N = Long.parseLong(input);
            K = 1;
            set = new HashSet<>();
            while (true) {
                String number = BigInteger.valueOf(N).multiply(BigInteger.valueOf(K)).toString();
                for (int i = 0; i < number.length(); i++) {
                    set.add(number.charAt(i));
                }

                if (set.size() == 10) {
                    break;
                }
                K++;
            }
            sb.append(K).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
