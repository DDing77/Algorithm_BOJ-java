import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        if (input.length() >= 5 && input.contains("M")
                && input.contains("O") && input.contains("B")
                && input.contains("I") && input.contains("S")) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
