import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private String input;
    private int res;

    private void solution() throws IOException {

        res = 1;
        input = br.readLine();
        char cur = input.charAt(0);
        char next;
        for (int i = 1; i < input.length(); i++) {
            next = input.charAt(i);
            if (next - 'a' <= cur - 'a') {
                res++;
            }
            cur = next;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
