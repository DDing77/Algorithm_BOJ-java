import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int n;
    private int res;

    private void solution() throws IOException {

        n = Integer.parseInt(br.readLine());
        if (n > 198) {
            System.out.println(0);
        } else {
            System.out.println(199 - n);
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
