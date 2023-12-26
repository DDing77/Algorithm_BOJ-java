import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int N;
    String input;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        input = br.readLine();

        System.out.println(input.substring(N - 5));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
