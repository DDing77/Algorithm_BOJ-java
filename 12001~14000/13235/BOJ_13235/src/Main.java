import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private String input;

    private void solution() throws IOException {

        input = br.readLine();
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                System.out.println("false");
                return;
            }
        }

        System.out.println("true");
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
