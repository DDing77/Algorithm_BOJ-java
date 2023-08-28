import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    String input;

    public boolean isPalindrome(String str) {
        int length = str.length();

        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            if (isPalindrome(input.substring(i))) {
                System.out.println(input.length() + i);
                return;
            }
        }

        System.out.println(input.length() * 2);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
