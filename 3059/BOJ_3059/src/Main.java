import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int T;
    static String input;
    static boolean[] alphabet;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input = br.readLine();

            alphabet = new boolean[26];
            for (int i = 0; i < input.length(); i++) {
                alphabet[input.charAt(i) - 'A'] = true;
            }

            int sum = 0;

            for (int i = 0; i < alphabet.length; i++) {
                if (!alphabet[i]) {
                    sum += i + 65;
                }
            }

            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
