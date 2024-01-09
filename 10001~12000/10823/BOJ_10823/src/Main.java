import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    String input = "";
    String[] numbers;
    int res;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        res = 0;

        String temp = "";
        while ((temp = br.readLine()) != null) {
            input = input.concat(temp);
        }

        numbers = input.split(",");
        for (String number : numbers) {
            res += Integer.parseInt(number);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
