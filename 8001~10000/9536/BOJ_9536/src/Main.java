import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private Set<String> set;
    private List<String> words;

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            set = new HashSet<>();
            words = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                words.add(st.nextToken());
            }

            while (true) {
                String input = br.readLine();
                if (input.equals("what does the fox say?")) {
                    for (String word : words) {
                        if (!set.contains(word)) {
                            sb.append(word).append(" ");
                        }
                    }
                    sb.append("\n");
                    break;
                } else {
                    st = new StringTokenizer(input);
                    st.nextToken();
                    st.nextToken();
                    set.add(st.nextToken());
                }
            }

        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
