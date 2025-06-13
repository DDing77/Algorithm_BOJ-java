import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private Set<Integer> set;

    private void solution() throws IOException {
        set = new HashSet<>();
        N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println("HAPPY");
            return;
        }

        set.add(N);
        while (N > 0) {
            int temp = N;
            int sum = 0;
            while (temp > 0) {
                int remainder = temp % 10;
                sum += remainder * remainder;
                temp = temp / 10;
            }
            if (set.contains(sum)) {
                System.out.println("UNHAPPY");
                return;
            }
            if (sum == 1) {
                System.out.println("HAPPY");
                return;
            }
            set.add(sum);
            N = sum;
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
