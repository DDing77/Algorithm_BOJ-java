import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    String input;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        input = input.replaceAll("[0-9]", "");

        if (input.contains(br.readLine())) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
