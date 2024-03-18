import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    static final Map<Character, Integer> map = new HashMap<>();

    String input;
    int res;

    private void makeMapTable() {

        map.put('-', 0);
        map.put('\\', 1);
        map.put('(', 2);
        map.put('@', 3);
        map.put('?', 4);
        map.put('>', 5);
        map.put('&', 6);
        map.put('%', 7);
        map.put('/', -1);
    }

    private void solution() throws IOException {

        makeMapTable();

        while (!(input = br.readLine()).equals("#")) {

            res = 0;
            for (int i = 0; i < input.length(); i++) {
                int cur = map.get(input.charAt(i));
                res *= 8;
                res += cur;
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
