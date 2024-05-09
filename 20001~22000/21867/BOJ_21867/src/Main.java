import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private String input;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        input = br.readLine();
        input = input.replaceAll("[J|V|A]", "");

        if (input.equals("")) {
            System.out.println("nojava");
        } else {
            System.out.println(input);
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
