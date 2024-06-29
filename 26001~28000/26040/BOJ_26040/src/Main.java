import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private void solution() throws IOException {

        String input = br.readLine();
        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()) {
            String target = st.nextToken();

            input = input.replace(target, target.toLowerCase());
        }

        System.out.println(input);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
