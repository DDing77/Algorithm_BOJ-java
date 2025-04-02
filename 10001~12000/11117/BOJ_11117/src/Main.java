import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private static final int ALPHABET_SIZE = 26;

    private int T;
    private int[] originCnt;
    private int N;
    private int[] patternCnt;

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            originCnt = new int[ALPHABET_SIZE];
            String W = br.readLine();
            for (int i = 0; i < W.length(); i++) {
                originCnt[W.charAt(i) - 'A']++;
            }

            N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                patternCnt = new int[ALPHABET_SIZE];
                String pattern = br.readLine();
                for (int j = 0; j < pattern.length(); j++) {
                    patternCnt[pattern.charAt(j) - 'A']++;
                }

                boolean flag = true;
                for (int j = 0; j < patternCnt.length; j++) {
                    if (originCnt[j] < patternCnt[j]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    sb.append("YES");
                } else {
                    sb.append("NO");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
