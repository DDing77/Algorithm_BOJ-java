import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int N;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if (N % 7 == 0 || N % 7 == 2) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
