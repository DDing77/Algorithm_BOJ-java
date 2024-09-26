import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private String input;
    private int res;

    private void solution() throws IOException {

        input = br.readLine();
        int pre = 0;
        for (int i = 0; i < input.length(); i++) {
            int cur = input.charAt(i) - 'A';
            int max = Math.max(pre, cur);
            int min = Math.min(pre, cur);

            res += Math.min(max - min, 25 - max + 1 + min);
            pre = cur;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
