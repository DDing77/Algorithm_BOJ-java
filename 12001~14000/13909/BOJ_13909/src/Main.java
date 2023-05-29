import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private int N;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        System.out.println((int) Math.floor(Math.sqrt(N)));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}