import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    int N;
    String input;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Pattern pattern = Pattern.compile("^[A-F]?A+F+C+[A-F]?$|^$");

        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            input = br.readLine();

            Matcher matcher = pattern.matcher(input);

            if (matcher.matches()) {
                sb.append("Infected!");
            } else {
                sb.append("Good");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
