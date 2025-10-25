import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private String str;

    private void solution() throws IOException {
        str = br.readLine();

        if (str.length() >= 3 && str.charAt(0) == '"' && str.charAt(str.length() - 1) == '"') {
            System.out.println(str.substring(1, str.length() - 1));
        } else {
            System.out.println("CE");
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
