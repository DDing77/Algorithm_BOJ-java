import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int N;

    private String getResult(int decimal) {
        if (decimal == 0) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        while (decimal > 0) {
            res.append(decimal % 9);
            decimal /= 9;
        }

        return res.reverse().toString();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        System.out.println(getResult(N));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
