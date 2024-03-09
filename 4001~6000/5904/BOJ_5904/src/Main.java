import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    static final String FIRST = "moo";

    int[] count;
    int N;

    private void makeCountTable() {
        count = new int[28];
        count[0] = 3;
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i - 1] * 2 + i + 3;
        }
    }

    private int findDepth(int cur) {

        int depth = -1;
        for (int i = 0; i < count.length; i++) {
            if (cur <= count[i]) {
                return i;
            }
        }

        return depth;
    }

    private void recur(int cur, int depth) {
        if (depth == 0) {
            sb.append(FIRST.charAt(cur - 1));
            return;
        }

        if (cur <= count[depth - 1]) {
            recur(cur, depth - 1);
        } else if (cur == count[depth - 1] + 1) {
            sb.append("m");
        } else if (cur <= count[depth] - count[depth - 1]) {
            sb.append("o");
        } else {
            recur(cur - (count[depth] - count[depth - 1]), depth - 1);
        }
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        makeCountTable();

        recur(N, findDepth(N));

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
