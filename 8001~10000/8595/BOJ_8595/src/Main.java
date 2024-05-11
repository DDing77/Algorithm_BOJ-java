import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private String input;

    private String findHiddenNumbers(String word) {
        BigInteger total = new BigInteger("0");
        BigInteger number = new BigInteger("0");
        boolean inNumber = false;

        for (char c : word.toCharArray()) {
            if (Character.isDigit(c)) {
                number = number.multiply(BigInteger.TEN);
                number = number.add(BigInteger.valueOf(Character.getNumericValue(c)));
                inNumber = true;
            } else {
                if (inNumber) {
                    total = total.add(number);
                    number = new BigInteger("0");
                    inNumber = false;
                }
            }
        }

        if (inNumber) {
            total = total.add(number);
        }

        return total.toString();
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        input = br.readLine();

        System.out.println(findHiddenNumbers(input));
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
