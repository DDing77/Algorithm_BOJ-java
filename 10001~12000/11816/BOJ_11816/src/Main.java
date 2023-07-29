import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    String input;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        if (input.charAt(0) != '0') {
            System.out.println(input);
        } else if (input.charAt(1) != 'x') {
            System.out.println(Integer.parseInt(input.substring(1), 8));
        } else {
            System.out.println(Integer.parseInt(input.substring(2), 16));
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
