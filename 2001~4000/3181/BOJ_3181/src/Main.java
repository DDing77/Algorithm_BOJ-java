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

    private Set<String> set;

    private void init() {
        set = new HashSet<String>();
        set.add("i");
        set.add("pa");
        set.add("te");
        set.add("ni");
        set.add("niti");
        set.add("a");
        set.add("ali");
        set.add("nego");
        set.add("no");
        set.add("ili");
    }

    private void solution() throws IOException {
        init();

        int idx = 0;
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            if (set.contains(word) && idx != 0) {
                continue;
            }
            idx++;
            sb.append(Character.toUpperCase(word.charAt(0)));
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
