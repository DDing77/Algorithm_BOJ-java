import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int T;
    static String input;
    static int cnt;

    public static int isPalindrome(int left, int right) {
        cnt++;
        if (left >= right) {
            return 1;
        } else if (input.charAt(left) != input.charAt(right)) {
            return 0;
        } else {
            return isPalindrome(left + 1, right - 1);
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input = br.readLine();


            cnt = 0;
            int res = isPalindrome(0, input.length() - 1);
            sb.append(res + " " + cnt).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
