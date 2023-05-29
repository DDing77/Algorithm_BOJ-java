import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int T;
    static int input;
    static ArrayList<Integer> converted;

    static void convert(int num, int b) {
        converted = new ArrayList<>();
        while (num > 0) {
            converted.add(num % b);
            num /= b;
        }
    }

    static boolean checkPalindrome() {
        for (int i = 0; i < converted.size() / 2; i++) {
            if (converted.get(i) != converted.get(converted.size() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            input = Integer.parseInt(br.readLine());
            boolean isPalindrome = false;

            for (int b = 2; b <= 64; b++) {
                convert(input, b);
                isPalindrome = checkPalindrome();
                if (isPalindrome) break;
            }

            if (!isPalindrome) sb.append(0).append('\n');
            else sb.append(1).append('\n');
        }

        System.out.print(sb);
    }
}
