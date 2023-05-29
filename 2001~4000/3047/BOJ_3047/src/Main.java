import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] input;
    static String pattern;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        input = new int[3];
        for (int i = 0; i < 3; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        pattern = br.readLine();

        for (int i = 0; i < 3; i++) {
            if (pattern.charAt(i) == 'A') {
                sb.append(input[0] + " ");
            } else if (pattern.charAt(i) == 'B') {
                sb.append(input[1] + " ");
            } else {
                sb.append(input[2] + " ");
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
