import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int N;
    static Set<String> words;
    static String input, reversed;
    static StringBuilder sb;
    static int length;
    static char mid;

    static String reverse(String input) {
        sb = new StringBuilder(input);
        return sb.reverse().toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        words = new HashSet<>();

        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            input = br.readLine();
            reversed = reverse(input);
            words.add(input);
            if (words.contains(reversed)) {
                length = input.length();
                mid = input.charAt(input.length() / 2);
                break;
            }
        }

        System.out.println(length + " " + mid);
    }
}
