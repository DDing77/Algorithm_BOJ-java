import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int A;
    int B;
    List<Integer> root;

    private int getRoot(String op) {

        int res = -1 * A;

        if (op.equals("+")) {
            return (int) (res + Math.sqrt(A * A - B));
        }
        return (int) (res - Math.sqrt(A * A - B));
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        root = new ArrayList<>();
        root.add(getRoot("+"));

        if (!root.contains(getRoot("-"))) {
            root.add(getRoot("-"));
        }

        Collections.sort(root);

        for (Integer num : root) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
