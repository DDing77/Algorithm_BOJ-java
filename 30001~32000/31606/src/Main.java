import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private void solution() throws IOException {
        int X = Integer.parseInt(br.readLine());
        int Y = Integer.parseInt(br.readLine());

        System.out.println(X + Y + 3);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
