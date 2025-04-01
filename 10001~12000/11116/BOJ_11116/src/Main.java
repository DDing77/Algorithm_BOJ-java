import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private int N;
    private int[] numbers;
    private Set<Integer> left;
    private Set<Integer> right;
    private int res;

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            numbers = new int[N];
            left = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
                left.add(numbers[i]);
            }

            right = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                right.add(Integer.parseInt(st.nextToken()));
            }

            res = 0;
            for (int number : numbers) {
                if (left.contains(number + 500) && right.contains(number + 1000) && right.contains(number + 1500)) {
                    res++;
                }
            }
            sb.append(res).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
