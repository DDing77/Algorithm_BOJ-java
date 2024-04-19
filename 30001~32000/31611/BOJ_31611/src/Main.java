import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    int x;

    private void solution() throws IOException {

        x = Integer.parseInt(br.readLine());

        if (x % 7 == 2) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
