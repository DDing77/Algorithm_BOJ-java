import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int B;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        B = Integer.parseInt(br.readLine());

        System.out.println((B / 11) * 10);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
