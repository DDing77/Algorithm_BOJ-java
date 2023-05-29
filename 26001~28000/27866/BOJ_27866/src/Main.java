import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private String input;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        System.out.println(input.charAt(Integer.parseInt(br.readLine()) - 1));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
