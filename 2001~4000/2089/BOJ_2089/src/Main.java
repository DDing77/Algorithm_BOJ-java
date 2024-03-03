import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    int N;

    private String toNegativeBinary(int decimalNumber) {
        if (decimalNumber == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        while (decimalNumber != 0) {

            int remainder = decimalNumber % -2;
            decimalNumber /= -2;

            if (remainder < 0) {
                remainder += 2;
                decimalNumber++;
            }

            result.insert(0, remainder);
        }

        return result.toString();
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        System.out.println(toNegativeBinary(N));
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
