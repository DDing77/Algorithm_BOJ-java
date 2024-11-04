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

    private void solution() throws IOException {

        while (true) {
            String input = br.readLine();

            if (input.equals("#")) {
                break;
            }

            input = input.toLowerCase();

            Set<Character> set = new HashSet<>();
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if ('a' <= ch && ch <= 'z') {
                    set.add(ch);
                }
            }
            sb.append(set.size()).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
