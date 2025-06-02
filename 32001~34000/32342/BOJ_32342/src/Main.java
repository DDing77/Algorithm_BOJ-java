import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int Q;
    private String pattern;
    private int[] pi;

    private int[] getPi(String pattern) {
        int length = pattern.length();
        int[] pi = new int[length];

        int j = 0;
        for (int i = 1; i < length; i++) {
            while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
                j = pi[j - 1];
            }
            if (pattern.charAt(j) == pattern.charAt(i)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }

    private List<Integer> KMP(String S) {
        int sLength = S.length();
        int pLength = pattern.length();
        List<Integer> idxList = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < sLength; i++) {
            while (j > 0 && S.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (S.charAt(i) == pattern.charAt(j)) {
                if (j == pLength - 1) {
                    idxList.add(i - pLength + 1);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        return idxList;
    }

    private void solution() throws IOException {
        Q = Integer.parseInt(br.readLine());
        pattern = "WOW";

        pi = getPi(pattern);

        while (Q-- > 0) {
            String S = br.readLine();

            List<Integer> res = KMP(S);
            sb.append(res.size()).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
