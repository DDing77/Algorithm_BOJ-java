import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static final Map<Character, Integer> ware = new HashMap<>();
    static final Set<Character> white = new HashSet<>();
    static final Set<Character> black = new HashSet<>();
    int sumWhite = 0;
    int sumBlack = 0;

    private void init() {
        ware.put('K', 0);
        ware.put('k', 0);
        ware.put('P', 1);
        ware.put('p', 1);
        ware.put('N', 3);
        ware.put('n', 3);
        ware.put('B', 3);
        ware.put('b', 3);
        ware.put('R', 5);
        ware.put('r', 5);
        ware.put('Q', 9);
        ware.put('q', 9);

        white.add('K');
        white.add('P');
        white.add('N');
        white.add('B');
        white.add('R');
        white.add('Q');

        black.add('k');
        black.add('p');
        black.add('n');
        black.add('b');
        black.add('r');
        black.add('q');
    }

    private void solution() throws IOException {
        for (int i = 0; i < 8; i++) {
            for (char c : br.readLine().toCharArray()) {
                if (white.contains(c)) {
                    sumWhite += ware.get(c);
                }
                if (black.contains(c)) {
                    sumBlack += ware.get(c);
                }
            }
        }
        sb.append(sumWhite - sumBlack);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.init();
        main.solution();
    }
}
