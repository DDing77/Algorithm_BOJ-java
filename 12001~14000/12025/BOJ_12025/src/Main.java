import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private void solution() throws IOException {

        String number = br.readLine();
        long k = Long.parseLong(br.readLine());

        char[] digits = number.toCharArray();

        int changeableCount = 0;

        for (int i = 0; i < digits.length; i++) {

            if (digits[i] == '1' || digits[i] == '6' || digits[i] == '2' || digits[i] == '7') {

                if (digits[i] == '6') {
                    digits[i] = '1';
                } else if (digits[i] == '7') {
                    digits[i] = '2';
                }

                changeableCount++;
            }
        }

        if ((1L << changeableCount) < k) {
            System.out.println(-1);
            return;
        }

        k--;

        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] != '1' && digits[i] != '2') {
                continue;
            }

            long bit = k & 1;
            k >>= 1;

            if (digits[i] == '1') {
                if (bit == 0) {
                    digits[i] = '1';
                } else {
                    digits[i] = '6';
                }
            } else {
                if (bit == 0) {
                    digits[i] = '2';
                } else {
                    digits[i] = '7';
                }
            }
        }

        System.out.println(new String(digits));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}