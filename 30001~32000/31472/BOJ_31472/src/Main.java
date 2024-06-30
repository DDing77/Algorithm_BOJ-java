import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int W;

    private void solution() throws IOException {

        W = Integer.parseInt(br.readLine());

        int a = (int) Math.sqrt(2 * W);
        System.out.println(4 * a);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
