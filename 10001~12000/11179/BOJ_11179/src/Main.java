import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int N;

    private String getBinary(int decimal) {
        if (decimal == 0) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        while (decimal > 0) {
            res.append(decimal % 2);
            decimal /= 2;
        }

        return res.toString();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String binaryNumber = getBinary(N);
        System.out.println(Integer.parseInt(binaryNumber, 2));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
