import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    int T;
    String inputNumber;

    public boolean isPalindrome(int number) {
        String numberToString = String.valueOf(number);
        int length = numberToString.length();

        for (int i = 0; i < length / 2; i++) {
            if (numberToString.charAt(i) != numberToString.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            inputNumber = br.readLine();
            int sum = Integer.parseInt(inputNumber);
            int length = inputNumber.length();

            String trans = "";
            for (int i = length - 1; i >= 0; i--) {
                trans += inputNumber.charAt(i);
            }

            sum += Integer.parseInt(trans);

            if (!isPalindrome(sum)) {
                sb.append("NO");
            } else {
                sb.append("YES");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
