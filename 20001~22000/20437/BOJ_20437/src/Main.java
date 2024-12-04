import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private char[] W;
    private ArrayList<Integer>[] alphaIndexes;
    private int K;

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            W = br.readLine().toCharArray();
            K = Integer.parseInt(br.readLine());

            alphaIndexes = new ArrayList[26];
            for (int i = 0; i < alphaIndexes.length; i++) {
                alphaIndexes[i] = new ArrayList<>();
            }

            for (int i = 0; i < W.length; i++) {
                alphaIndexes[W[i] - 'a'].add(i);
            }

            int resMin = W.length;
            int resMax = -1;
            Set<Character> cached = new HashSet<>();
            for (int i = 0; i < W.length; i++) {
                if (cached.contains(W[i])) {
                    continue;
                }

                cached.add(W[i]);
                int target = W[i] - 'a';
                for (int j = K - 1; j < alphaIndexes[target].size(); j++) {
                    int length = alphaIndexes[target].get(j) - alphaIndexes[target].get(j - K + 1) + 1;
                    resMax = Math.max(resMax, length);
                    resMin = Math.min(resMin, length);
                }
            }
            if (resMax == -1) {
                sb.append("-1");
            } else {
                sb.append(resMin).append(" ").append(resMax);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
