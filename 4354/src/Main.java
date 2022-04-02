import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            pattern = br.readLine();
            if (pattern.charAt(0) == '.') break;
            failureFunction();
            int length = pattern.length();
            int res = length % (length - pi[length-1]) != 0 ? 1 : length / ( length - pi[length -1]);
            sb.append(res).append('\n');
        }
        System.out.print(sb);
    }
}
