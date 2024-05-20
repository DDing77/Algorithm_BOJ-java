import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private String input;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 8; i++) {
            String bit = st.nextToken();
            if (!(bit.equals("0") || bit.equals("1"))) {
                System.out.println("F");
                return;
            }
        }
        System.out.println("S");
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
