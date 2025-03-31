import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private static final String pattern = "driip";

    private String S;

    private void solution() throws IOException {
        S = br.readLine();

        if (S.length() >= pattern.length() && S.substring(S.length() - pattern.length()).equals(pattern)) {
            System.out.println("cute");
        } else {
            System.out.println("not cute");
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
