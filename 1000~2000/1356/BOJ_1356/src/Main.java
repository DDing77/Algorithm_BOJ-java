import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    String input;
    int[] left;
    int[] right;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        int length = input.length();

        left = new int[length + 1];
        right = new int[length + 1];

        for (int i = 0; i < length - 1; i++) {

            if (i == 0) {
                left[i] = input.charAt(i) - '0';
                right[length - 1] = input.charAt(length - 1) - '0';
                continue;
            }

            left[i] = left[i - 1] * (input.charAt(i) - '0');
            right[length - 1 - i] = right[length - i] * (input.charAt(length - 1 - i) - '0');
        }

        for (int i = 0; i < length - 1; i++) {
            if (left[i] == right[i + 1]) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");

    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
