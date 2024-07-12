import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private char[] trees;
    private int maxLevel;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            trees = br.readLine().toCharArray();

            int level = 0;
            maxLevel = level;

            for (int i = 0; i < trees.length; i++) {
                if (trees[i] == '[') {
                    level++;
                    maxLevel = Math.max(maxLevel, level);
                } else {
                    level--;
                }
            }

            sb.append((int) Math.pow(2, maxLevel)).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
