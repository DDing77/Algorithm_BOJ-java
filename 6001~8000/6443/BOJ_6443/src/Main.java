import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int N;
    static int[] cnt;
    static String str;
    static char[] make;
    static StringBuilder sb;

    public static void execDFS(int depth) {
        if (depth == str.length()) {
            for (int i = 0; i < str.length(); i++) {
                sb.append(make[i]);
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                cnt[i]--;
                make[depth] = (char) (i + 'a');
                execDFS(depth + 1);
                cnt[i]++;
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            cnt = new int[26];
            str = br.readLine();
            make = new char[str.length()];

            for (int i = 0; i < str.length(); i++) {
                cnt[str.charAt(i) - 'a']++;
            }

            execDFS(0);
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
