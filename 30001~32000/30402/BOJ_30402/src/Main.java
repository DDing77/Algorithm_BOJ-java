import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static final Set<String> set = new HashSet<>();
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    private void init() {
        set.add("r");
        set.add("o");
        set.add("y");
        set.add("p");
    }

    private void solution() throws IOException {
        init();

        for (int i = 0; i < 15; i++) {
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                String input = st.nextToken();

                if (set.contains(input)) {
                    continue;
                }

                if (input.equals("w")) {
                    System.out.println("chunbae");
                    return;
                }
                if (input.equals("b")) {
                    System.out.println("nabi");
                    return;
                }
                if (input.equals("g")) {
                    System.out.println("yeongcheol");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
