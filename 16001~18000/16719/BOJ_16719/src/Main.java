import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    String input;
    boolean[] isVisited;

    private void recur(int left, int right) {

        if (left > right) {
            return;
        }

        int minIdx = left;
        for (int i = left; i <= right; i++) {
            if (input.charAt(minIdx) > input.charAt(i)) {
                minIdx = i;
            }
        }

        isVisited[minIdx] = true;

        for (int i = 0; i < isVisited.length; i++) {
            if (isVisited[i]) {
                sb.append(input.charAt(i));
            }
        }
        sb.append("\n");

        recur(minIdx + 1, right);
        recur(left, minIdx - 1);
    }

    private void solution() throws IOException {

        input = br.readLine();
        isVisited = new boolean[input.length()];

        recur(0, input.length() - 1);

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
