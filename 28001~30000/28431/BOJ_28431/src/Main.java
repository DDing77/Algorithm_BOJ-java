import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int[] sock;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sock = new int[10];
        for (int i = 0; i < 5; i++) {
            sock[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 0; i < sock.length; i++) {
            if (sock[i] % 2 == 1) {
                System.out.println(i);
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
