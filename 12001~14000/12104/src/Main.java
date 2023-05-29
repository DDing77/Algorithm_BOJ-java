import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String parent;
    static String pattern;
    static int[] pi;

    static void failureFunction() {
        pi = new int[pattern.length()];
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }
    }

    static int KMP() {
        failureFunction();
        int cnt = 0;
        int j = 0;
        for (int i = 0; i < parent.length() - 1; i++) {
            while (j > 0 && parent.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (parent.charAt(i) == pattern.charAt(j)) {
                if (pattern.length() - 1 == j) {
                    cnt++;
                    j = pi[j];
                } else j++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        parent = br.readLine();
        pattern = br.readLine();

        parent += parent;
        int res = KMP();
        System.out.println(res);
    }
}