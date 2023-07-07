import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final char[] pattern = {'C', 'A', 'M', 'B', 'R', 'I', 'D', 'G', 'E'};
    static String input;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            boolean isContain = false;
            for (int j = 0; j < pattern.length; j++) {
                if (input.charAt(i) == pattern[j]) {
                    isContain = true;
                    break;
                }
            }

            if (!isContain) {
                sb.append(input.charAt(i));
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
