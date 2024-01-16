import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    final String MESSAGE = "WelcomeToSMUPC";
    int N;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()) - 1;

        int idx = N % 14;
        System.out.println(MESSAGE.charAt(idx));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
