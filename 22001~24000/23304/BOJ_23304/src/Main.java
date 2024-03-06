import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    String input;

    private boolean isPalindrome(int left, int right) {

        if (left == right) {
            return true;
        }

        for (int i = 0; i < (right - left) / 2; i++) {
            if (input.charAt(left + i) != input.charAt(right - i)) {
                return false;
            }
        }

        return isPalindrome(left, (left + right + 1) / 2 - 1);
    }

    private void solution() throws IOException {

        input = br.readLine();

        if (isPalindrome(0, input.length() - 1)) {
            System.out.println("AKARAKA");
        } else {
            System.out.println("IPSELENTI");
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
